package com.problem2.geolocation.model;

/**
 * Classroom Class.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class Classroom extends Entity{

    /**
     * Constructor
     */
    public Classroom() {
        super();
    }

    /**
     * Constructor to create a Classroom.
     * @param name the class's name.
     * @param latitude the class's latitude.
     * @param longitude the class's longitude.
     */
    public Classroom(String name, Double latitude, Double longitude) {
        super(name, latitude, longitude);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                    "name='" + this.getName() + '\'' +
                    ", latitude=" + this.getLatitude() +
                    ", longitude=" + this.getLongitude() +
                    '}';
    }
}
