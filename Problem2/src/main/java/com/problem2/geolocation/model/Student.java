package com.problem2.geolocation.model;

/**
 * Student Class.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class Student extends Entity{

    /**
     * Constructor
     */
    public Student() {
        super();
    }

    /**
     * Constructor to create a Student.
     * @param name the class's name.
     * @param latitude the class's latitude.
     * @param longitude the class's longitude.
     */
    public Student(String name, Double latitude, Double longitude) {
        super(name, latitude, longitude);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + this.getName() + '\'' +
                ", latitude=" + this.getLatitude() +
                ", longitude=" + this.getLongitude() +
                '}';
    }
}
