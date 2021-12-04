package sk.fri.uniza.sporthealthsystem.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.dto.DBFile;
import sk.fri.uniza.sporthealthsystem.security.user.AuthenticationUser;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AuthenticationUser {
    private Instant datum_posled_prihlasenia;
    private Instant datum_registracie;
    private String rola;
    private DBFile image;
}

