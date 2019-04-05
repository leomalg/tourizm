package fr.malgrange.tourizm.web.error;

import fr.malgrange.tourizm.service.exception.BadRequestException;
import fr.malgrange.tourizm.service.exception.NotFoundException;
import fr.malgrange.tourizm.service.exception.TechnicalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static ResponseEntity<List<String>> exceptionHandler(final List<String> errors, HttpStatus errorStatus) {
        return ResponseEntity
                .status(errorStatus)
                .body(errors);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseEntity<List<String>> badRequestExceptionOccured(final BadRequestException badRequestException) {
        return exceptionHandler(badRequestException.getErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<List<String>> technicalExceptionOccured(final NotFoundException notFoundException) {
        return exceptionHandler(notFoundException.getErrors(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TechnicalException.class)
    @ResponseBody
    public ResponseEntity<List<String>> notFoundExceptionOccured(final TechnicalException technicalException) {
        return exceptionHandler(technicalException.getErrors(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<List<String>> unknowExceptionOccurred(final Exception exception) {
        return exceptionHandler(Collections.singletonList(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
