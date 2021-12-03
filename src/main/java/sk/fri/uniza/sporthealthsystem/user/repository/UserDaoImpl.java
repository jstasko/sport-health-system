package sk.fri.uniza.sporthealthsystem.user.repository;

import org.dozer.DozerBeanMapper;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.fri.uniza.sporthealthsystem.user.entity.ERole;
import sk.fri.uniza.sporthealthsystem.user.entity.User;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

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

        if(userDto.getDatum_registracie() == null) {
            userDto.setDatum_registracie(Instant.now());
        }

        if (userDto.getDatum_posled_prihlasenia() == null) {
            userDto.setDatum_posled_prihlasenia(Instant.now());
        }

        if (userDto.getRola() == null) {
            userDto.setRola("Regular");
        }

//        if (userDto.getRole() == null) {
//            userDto.setRole(ERole.ROLE_ADMIN);
//        }

        UserDto newUserDto = this.userRepository.save(userDto);
        return this.mapper.map(newUserDto, User.class);
    }

    @Override
    public User findUserByEmail(String email) {
        UserDto userDto = userRepository.findByEmail(email);
        if (userDto == null) {
            return null;
        }
        return this.mapper.map(userDto, User.class);
    }
}

