package sk.fri.uniza.sporthealthsystem.user.repository;

import sk.fri.uniza.sporthealthsystem.user.entity.User;

public interface UserDao {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
    User save(User user);
}

