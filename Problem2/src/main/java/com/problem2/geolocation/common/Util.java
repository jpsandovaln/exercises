package com.problem2.geolocation.common;

/**
 * Util class.
 * @author Paolo Sandoval
 * @version 1.0
 */
public class Util {

    /**
     * Gets the distance oin meters of two points.
     * @param firstLatitude the first latitude value.
     * @param firstLongitude the first longitude value.
     * @param secondLatitude the second latitude value.
     * @param secondLongitude the second longitude value.
     * @return the distance between two points.
     */
    public static Double getDistanceInMeters(Double firstLatitude, Double firstLongitude,
                                      Double secondLatitude, Double secondLongitude) {
        Double latDistance = toRad(secondLatitude - firstLatitude);
        Double lonDistance = toRad(secondLongitude - firstLongitude);
        Double squareDistance = Math.sin(latDistance / Constants.SPLIT) * Math.sin(latDistance / Constants.SPLIT) +
                Math.cos(toRad(firstLatitude)) * Math.cos(toRad(secondLatitude)) *
                        Math.sin(lonDistance / Constants.SPLIT) * Math.sin(lonDistance / Constants.SPLIT);
        Double radiansDistance = Constants.SPLIT * Math.atan2(Math.sqrt(squareDistance), Math.sqrt(1 - squareDistance));
        Double distance = Constants.EARTH_RADIOUS_KM * radiansDistance;

        Double meters = distance * Constants.MT_ON_KM;
        return meters;
    }

    /**
     * Convert to radiant.
     * @param value the value to convert.
     * @return the converted value.
     */
    public static Double toRad(Double value) {
        return value * Math.PI / Constants.DEGREE;
    }
}
