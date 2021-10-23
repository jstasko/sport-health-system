package sk.fri.uniza.sporthealthsystem.core;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
public abstract class BaseDocumentDto {
    @Id
    private String id;
    @CreatedDate
    private DateTime create;
    @LastModifiedDate
    private DateTime edit;
}
