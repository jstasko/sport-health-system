package sk.fri.uniza.sporthealthsystem.user.repository;

import org.springframework.data.repository.CrudRepository;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;
import sk.fri.uniza.sporthealthsystem.user.entity.User;

public interface UserRepository extends CrudRepository<UserDto, String> {
    UserDto findByEmail(String email);
}

