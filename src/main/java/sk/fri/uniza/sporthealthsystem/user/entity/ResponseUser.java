package sk.fri.uniza.sporthealthsystem.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.entity.UploadFileResponse;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUser {
    private String email;
    private Instant datum_posled_prihlasenia;
    private Instant datum_registracie;
    private UploadFileResponse avatar;
}
