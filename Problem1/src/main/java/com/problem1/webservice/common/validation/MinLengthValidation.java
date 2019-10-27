package com.problem1.webservice.common.validation;

import com.problem1.webservice.exception.ParameterInvalidException;

/**
 * Class to validate is if a field value length is correct..
 * @author Paolo Sandoval
 * @version 1.0
 */
public class MinLengthValidation implements IValidationStrategy {

    int minValue;
    String value;
    String fieldName;

    /**
     * Constructor to create a new validation.
     * @param minValue the min value.
     * @param value the field value.
     * @param fieldName the field name.
     */
    public MinLengthValidation(int minValue, String value, String fieldName) {
        this.value = value;
        this.fieldName = fieldName;
        this.minValue = minValue;
    }

    /**
     * Validates if a field value length is ok.
     * @throws ParameterInvalidException
     */
    public void validate() throws ParameterInvalidException {
        if (this.value.length() < this.minValue) {
            throw new ParameterInvalidException(this.fieldName);
        }
    }
}
