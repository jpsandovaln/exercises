package com.problem1.webservice.common.validation;

import com.problem1.webservice.exception.ParameterInvalidException;

import java.util.List;

/**
 * Context validation class.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class ContextValidation {

    List<IValidationStrategy> validationList;

    /**
     * Constructor to create a new context.
     * @param strategies the validation list.
     */
    public ContextValidation(List<IValidationStrategy> strategies) {
        this.validationList = strategies;
    }

    /**
     * Executes the validations
     * @throws ParameterInvalidException when the parameter is invalid.
     */
    public void validata() throws ParameterInvalidException {
        for (IValidationStrategy strategy : validationList)
        {
            strategy.validate();
        }
    }
}
