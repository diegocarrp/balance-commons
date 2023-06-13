package cl.diego.balance.commons.rest.domain;

import cl.diego.balance.commons.rest.exception.ApiValidationException;
import lombok.Data;

import java.util.List;

@Data
public class ApiValidationError extends ApiError {
    private List<ApiSubError> subErrors;

    public ApiValidationError( ApiValidationException ex ) {
        super( ex.getStatus( ), ex.getMessage( ) );
        this.subErrors = ex.getSubErrors( );
    }
}
