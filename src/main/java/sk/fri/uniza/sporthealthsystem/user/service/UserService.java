package sk.fri.uniza.sporthealthsystem.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sk.fri.uniza.sporthealthsystem.user.entity.User;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User findUserByUsername(String username);
    User signUp(User user);
}

