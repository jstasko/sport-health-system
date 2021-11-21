package sk.fri.uniza.sporthealthsystem.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotSaveException extends RuntimeException {
    public NotSaveException(String message) {
        super(message);
    }
}
