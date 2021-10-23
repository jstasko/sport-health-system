package sk.fri.uniza.sporthealthsystem.user.repository;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.user.entity.User;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;

@Component
public class UserDaoImpl implements UserDao {
    private final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private final DozerBeanMapper mapper;
    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository repository, DozerBeanMapper mapper) {
        this.mapper = mapper;
        this.userRepository = repository;
    }

    public User save(User user) {
        logger.info("user is being saved");
        UserDto userDto = this.mapper.map(user, UserDto.class);
        UserDto newUserDto = this.userRepository.save(userDto);
        if (newUserDto.getId() != null) {
            logger.info("user was saved");
            return this.mapper.map(userDto, User.class);
        }
        logger.trace("Use have not been saved properly, missing id");
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        UserDto userDto = userRepository.findByUsername(username);
        if (userDto != null) {
            return this.mapper.map(userDto, User.class);
        }
        return null;
    }

    @Override
    public User findUserByEmail(String firstName) {
        UserDto userDto = userRepository.findByEmail(firstName);
        return this.mapper.map(userDto, User.class);
    }
}

