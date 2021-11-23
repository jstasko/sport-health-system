package sk.fri.uniza.sporthealthsystem.module.fileMedia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.dto.DoctorDto;
import sk.fri.uniza.sporthealthsystem.user.dto.UserDto;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "m_image")
public class DBFile {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "MIME_TYPE")
    private String fileType;
    @Column(name = "OTHER_DATA")
    private String fileName;
    @Lob
    @Column(name = "AVATAR")
    private byte[] data;
    @Column(name = "FILE_SIZE")
    private long fileSize;
    @Column(name = "CREATED")
    private Instant created;

    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    private UserDto user;

    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    private DoctorDto doctor;

    public DBFile(String fileType, String fileName, byte[] data, long fileSize, Instant created) {
        this.fileType = fileType;
        this.fileName = fileName;
        this.data = data;
        this.fileSize = fileSize;
        this.created = created;
        this.id = null;
    }
}
