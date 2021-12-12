package de.unistuttgart.iste.sqa.pse.sheet10.homework.exercise1;

/**
 * This is the implementation of a Location in Mensch�rgereDichNicht
 *
 * @author Sven Naber
 * @version 1.0
 */
public class Location {
    Zone zone;
    int coordinate;

    /**
     * Class constructor
     *
     * @param zone       the zone (START,FIELD,GOAL) of the piece
     * @param coordinate the coordinate of the piece inside the zone (START 0; GOAL 0-3; FIELD 0-39)
     */
    public Location(Zone zone, int coordinate) {
        this.zone = zone;
        this.coordinate = coordinate;
    }

    /**
     * Getter for zone
     *
     * @returns zone
     */
    public Zone getZone() {
        return zone;
    }

    /**
     * Setter for zone
     *
     * @param zone the zone (START,FIELD,GOAL) of the piece
     * @ensures this.zone = zone
     */
    public void setZone(Zone zone) {
        this.zone = zone;
    }

    /**
     * Custom toString of Location
     *
     * @ensures Location printed to console
     */
    public String toString() {
        return "Zone: " + this.getZone() + ", Coordinate: " + this.getCoordinate();
    }

    /**
     * Getter for coordinate
     *
     * @returns coordinate
     */
    public int getCoordinate() {
        return coordinate;
    }

    /**
     * Setter for coordinate
     *
     * @param coordinate the coordinate of the piece inside the zone (START 0; GOAL 0-3; FIELD 0-39)
     * @ensures this.coordinate = coordinate
     */
    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }

}
