package de.unistuttgart.iste.sqa.pse.sheet10.presence.exercise2;

import java.util.Date;

/**
 * This class represents a ventilator which should be opened independent of the
 * current temperature.
 *
 * @version 08.12.2021
 */
public class Ventilator {
    public int id;
    private int width;
    private int height;
    private boolean on;
    private Date purchaseDate;
    private int powerClimatisation;

    protected void turnOn() {
    }

    protected void turnOff() {
    }

    protected boolean isOn() {
        return this.on;
    }

}
