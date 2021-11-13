package sk.fri.uniza.sporthealthsystem.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.security.user.AuthenticationUser;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AuthenticationUser {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private Date create;
}

