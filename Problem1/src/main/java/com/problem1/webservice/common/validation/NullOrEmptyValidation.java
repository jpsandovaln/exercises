package com.problem1.webservice.common.validation;

import com.problem1.webservice.exception.ParameterInvalidException;

/**
 * Class to validate is if a field value is null or empty.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class NullOrEmptyValidation  implements IValidationStrategy {

    String value;
    String field;

    /**
     * Constructor to create a new validation.
     * @param value the field value.
     * @param field the field name.
     */
    public NullOrEmptyValidation(String value, String field) {
        this.value = value;
        this.field = field;
    }

    /**
     * Validates if a field value is null or empty
     * @throws ParameterInvalidException
     */
    public void validate() throws ParameterInvalidException {
        if (null == value || value.isEmpty()) {
            throw new ParameterInvalidException(this.field);
        }
    }
}
