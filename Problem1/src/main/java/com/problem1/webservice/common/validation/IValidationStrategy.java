package com.problem1.webservice.common.validation;

import com.problem1.webservice.exception.ParameterInvalidException;

/**
 * Interface to validate.
 * @author Paolo Sandoval
 * @version 1.0
 */
public interface IValidationStrategy {
    void validate() throws ParameterInvalidException;
}
