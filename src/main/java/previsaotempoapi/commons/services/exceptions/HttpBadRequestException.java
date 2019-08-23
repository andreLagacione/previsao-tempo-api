package previsaotempoapi.commons.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HttpBadRequestException extends RuntimeException {
    public HttpBadRequestException() {}

    public HttpBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
