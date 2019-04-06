package fr.malgrange.tourizm.web.error;

import fr.malgrange.tourizm.service.exception.BadRequestException;
import fr.malgrange.tourizm.service.exception.NotFoundException;
import fr.malgrange.tourizm.service.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(ControllerExceptionHandler.class);

    private static ResponseEntity<List<String>> exceptionHandler(final List<String> errors, HttpStatus errorStatus) {
        return ResponseEntity
                .status(errorStatus)
                .body(errors);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public ResponseEntity<List<String>> badRequestExceptionOccured(final BadRequestException badRequestException) {
        LOGGER.error(badRequestException.getErrors(), badRequestException);
        return exceptionHandler(badRequestException.getErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<List<String>> notFoundExceptionOccured(final NotFoundException notFoundException) {
        LOGGER.error(notFoundException.getErrors(), notFoundException);
        return exceptionHandler(notFoundException.getErrors(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TechnicalException.class)
    @ResponseBody
    public ResponseEntity<List<String>> technicalExceptionOccured(final TechnicalException technicalException) {
        LOGGER.error(technicalException.getErrors(), technicalException);
        return exceptionHandler(technicalException.getErrors(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<List<String>> unknowExceptionOccurred(final Exception exception) {
        LOGGER.error(exception);
        return exceptionHandler(Collections.singletonList("Une erreur inconnue est survenue. Veuillez contacter votre administrateur."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
