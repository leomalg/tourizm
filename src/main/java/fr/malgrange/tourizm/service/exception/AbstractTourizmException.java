package fr.malgrange.tourizm.service.exception;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTourizmException extends RuntimeException {

    private final List<String> errors = new ArrayList<>();

    AbstractTourizmException(String error) {
        super();
        this.errors.add(error);
    }

    AbstractTourizmException(List<String> errors) {
        super();
        this.errors.addAll(errors);
    }

    public List<String> getErrors() {
        return errors;
    }
}
