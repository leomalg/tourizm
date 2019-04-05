package fr.malgrange.tourizm.service.exception;

import java.util.List;

public class BadRequestException extends AbstractTourizmException {

    public BadRequestException(String error) {
        super(error);
    }

    public BadRequestException(List<String> errors ) {
        super(errors);
    }
}
