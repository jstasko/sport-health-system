package sk.fri.uniza.sporthealthsystem.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sk.fri.uniza.sporthealthsystem.core.exception.NotFoundException;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.service.FileMediaServiceImpl;
import sk.fri.uniza.sporthealthsystem.user.entity.ResponseUser;
import sk.fri.uniza.sporthealthsystem.user.entity.User;
import sk.fri.uniza.sporthealthsystem.user.repository.UserDao;
import sk.fri.uniza.sporthealthsystem.user.repository.UserDaoImpl;

import java.time.Instant;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final FileMediaServiceImpl fileMediaServiceImpl;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(
            UserDaoImpl dao,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            FileMediaServiceImpl fileMediaServiceImpl
    ) {
        this.userDao = dao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.fileMediaServiceImpl = fileMediaServiceImpl;
    }

    @Override
    public User findByEmail(String email) {
        return this.userDao.findUserByEmail(email);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByEmail(username);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User applicationUser = userDao.findUserByEmail(email);
        if (applicationUser == null) {
            logger.trace("User is not found");
            throw new UsernameNotFoundException(email);
        }
        logger.trace("Setting a new date for last login");
        applicationUser.setDatum_posled_prihlasenia(Instant.now());
        userDao.save(applicationUser);
        return new org.springframework.security.core.userdetails.User
                (applicationUser.getEmail(), applicationUser.getHeslo(), emptyList());

    }

    @Override
    public User signUp(User user) {
        if (user.getEmail() == null || user.getHeslo() == null) {
            logger.trace("User was not created .. credentials are missing");
            return null;
        }
        if (user.getHeslo().isEmpty() || user.getEmail().isEmpty()) {
            logger.trace("User was not created .. credentials were not set");
            return null;
        }
        User helpUser = userDao.findUserByEmail(user.getEmail());

        if (helpUser != null) {
            throw new RuntimeException("User is already created");
        }

        logger.trace("New User is created .. credentials  username " + user.getEmail());
        logger.info("Password is being encoded");
        user.setHeslo(this.bCryptPasswordEncoder.encode(user.getHeslo()));
        return this.userDao.save(user);
    }

    @Override
    public User saveAvatarToUser(String email, MultipartFile file, boolean replace) {
        logger.info("Searching user with given email " +  email);
        User user = this.userDao.findUserByEmail(email);

        if (user == null) {
            logger.trace("User does not exists");
            throw new NotFoundException("User does not exists");
        }
        if (user.getImage() != null) {
            logger.trace("User has avatar already");

            if (replace) {
                logger.trace("Old avatar is deleted");
                this.fileMediaServiceImpl.deleteById(user.getImage().getId());
            }
        }

        if (replace || user.getImage() == null) {
            logger.trace("setting new image");
            DBFile avatar = this.fileMediaServiceImpl.uploadFile(file);
            user.setImage(avatar);
        }

        return this.userDao.save(user);
    }

    public ResponseUser buildResponseUser(User user) {
        if (user == null) {
            return null;
        }
        return new ResponseUser(
                user.getEmail(),
                user.getDatum_posled_prihlasenia(),
                user.getDatum_registracie(),
                this.fileMediaServiceImpl.buildUploadFile(user.getImage())
        );
    }
}

