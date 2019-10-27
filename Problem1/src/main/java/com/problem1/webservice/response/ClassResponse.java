package com.problem1.webservice.response;

import com.problem1.webservice.common.validation.ContextValidation;
import com.problem1.webservice.common.validation.MinLengthValidation;
import com.problem1.webservice.exception.ParameterInvalidException;
import com.problem1.webservice.common.validation.IValidationStrategy;
import com.problem1.webservice.common.validation.NullOrEmptyValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Response.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class ClassResponse {

    private Long classId;
    private String code;
    private String title;
    private String description;

    static final int MIN_LENGTH = 4;

    /**
     * Constructor
     */
    public ClassResponse() {
    }

    /**
     * Constructor to create a Class.
     * @param classId the class's id.
     * @param code the class's code.
     * @param title the class's title.
     * @param description the class's description.
     */
    public ClassResponse(Long classId, String code, String title, String description) {
        this.classId = classId;
        this.code = code;
        this.title = title;
        this.description = description;
    }

    /**
     * Gets the class's id.
     * @return a number representing the class's id.
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * Sets the Class's id.
     * @param classId the class's id.
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /**
     * Gets the class's code.
     * @return a string representing the class's code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the Class's code.
     * @param code the class's code.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the class's title.
     * @return a string representing the class's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the Class's title.
     * @param title the class's title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the class's description.
     * @return a string representing the class's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the Class's description.
     * @param description the class's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Validates fields.
     * @throws ParameterInvalidException
     */
    public void validate() throws ParameterInvalidException {
        List<IValidationStrategy> validationList = new ArrayList<>();
        validationList.add(new NullOrEmptyValidation(this.code, "code"));
        validationList.add(new NullOrEmptyValidation(this.title, "title"));
        validationList.add(new MinLengthValidation(MIN_LENGTH, this.title, "title"));
        ContextValidation context = new ContextValidation(validationList);
        context.validata();
    }
}
