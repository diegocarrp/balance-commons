package cl.diego.balance.commons.rest.domain;

import cl.diego.balance.commons.rest.exception.ApiException;
import org.springframework.http.HttpStatus;

public class BadInputException extends ApiException {
    public BadInputException( ) {
        super( HttpStatus.BAD_REQUEST, "Input data has errors." );
    }
}
