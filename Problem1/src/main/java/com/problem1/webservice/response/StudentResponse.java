package com.problem1.webservice.response;

/**
 * Student Response.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class StudentResponse {

    private long id;
    private String firstName;
    private String lastName;

    /**
     * Constructor
     */
    public StudentResponse() {
    }

    /**
     * Constructor to create a student response.
     * @param id the student's id.
     * @param firstName the student's first name.
     * @param lastName the student's last name.
     */
    public StudentResponse(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the student's id.
     * @return a number representing the student's id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the student's id.
     * @param id the student's id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the student's first name.
     * @return a string representing the student's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     * @param firstName the student's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the student's last name.
     * @return a string representing the student's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     * @param lastName the student's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
