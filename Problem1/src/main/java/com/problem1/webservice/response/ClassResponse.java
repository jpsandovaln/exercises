package com.problem1.webservice.response;

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
}
