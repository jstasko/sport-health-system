package sk.fri.uniza.sporthealthsystem.user.repository;

import org.springframework.data.repository.CrudRepository;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;

public interface UserRepository extends CrudRepository<UserDto, String> {
    UserDto findByFirstName(String firstName);
    UserDto findByEmail(String email);
    UserDto findByUsername(String email);
}

