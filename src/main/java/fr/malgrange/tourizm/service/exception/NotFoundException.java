package fr.malgrange.tourizm.service.exception;

public class NotFoundException extends AbstractTourizmException {

    public NotFoundException(String error) {
        super(error);
    }
}
