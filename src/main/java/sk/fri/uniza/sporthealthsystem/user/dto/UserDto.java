package sk.fri.uniza.sporthealthsystem.user.dto;

import lombok.Getter;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.core.BaseDocumentDto;

@Getter
@Setter
public class UserDto extends BaseDocumentDto {
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
}

