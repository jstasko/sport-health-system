package sk.fri.uniza.sporthealthsystem.security.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AuthenticationUser {
    private String username;
    private String email;
    private String password;
}
