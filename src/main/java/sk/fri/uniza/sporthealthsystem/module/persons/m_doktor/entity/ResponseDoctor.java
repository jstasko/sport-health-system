package sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.entity.UploadFileResponse;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDoctor {
    private String id;
    private String meno;
    private String priezvisko;
    private String download;
    private String rodCislo;
}
