package de.unistuttgart.iste.sqa.pse.sheet10.presence.exercise2;

/**
 * This class represents a cage in which a defined number of laying poultries can live.
 *
 * @version 08.12.2021
 */
public class Cage<T extends LayingPoultry> {
    public int id;
    private int height;
    private double width;
    private int capacity;
    private boolean isFull;
}
