package com.problem2.geolocation.model;

import java.util.Objects;

/**
 * Entity Class.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class Entity {
    private String name;
    private Double latitude;
    private Double longitude;

    public Entity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return name.equals(entity.name) &&
                latitude.equals(entity.latitude) &&
                longitude.equals(entity.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude);
    }

    /**
     * Constructor to create a Entity.
     * @param name the class's name.
     * @param latitude the class's latitude.
     * @param longitude the class's longitude.
     */
    public Entity(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Gets the Entity's name.
     * @return a string representing the Entity's name.
     */
    protected String getName() {
        return name;
    }

    /**
     * Sets the Entity's name.
     * @param name the Entity's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Entity's latitude.
     * @return a string representing the Entity's latitude.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the Entity's latitude.
     * @param latitude the Entity's latitude.
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the Entity's longitude.
     * @return a string representing the Entity's longitude.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the Entity's longitude.
     * @param longitude the Entity's longitude.
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
