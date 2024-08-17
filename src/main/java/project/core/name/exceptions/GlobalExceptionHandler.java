package project.core.name.exceptions;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import project.core.name.exceptions.indentification.RegistrationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleRegistrationException(ConstraintViolationException e) {

        ErrorResponse errorResponse = new ErrorResponse("BAD_REQUEST", stringFix(e.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RegistrationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleRegistrationException2(RegistrationException e) {

        ErrorResponse errorResponse = new ErrorResponse("BAD_REQUEST", stringFix(e.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @Setter
    @Getter
    class ErrorResponse {

        private String errorCode;
        private String errorMessage;

        public ErrorResponse(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }
    }

    private static String stringFix(String message) {
        return message.replaceAll( ".*" + ": ", "");
    }
}
