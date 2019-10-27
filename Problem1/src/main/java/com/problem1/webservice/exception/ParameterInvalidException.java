package com.problem1.webservice.exception;

/**
 * Parameter invalid exception.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class ParameterInvalidException extends Exception  {

    String paramName;
    String message = "";

    /**
     * Constructor to create a new exception.
     * @param paramName the parameter name.
     */
    public ParameterInvalidException(String paramName) {
        this.paramName = paramName;
    }

    /**
     * Gets the error message.
     * @return the error message.
     */
    @Override
    public String getMessage() {
        message = "the parameter " + paramName + " is invalid";
        return message;
    }
}
