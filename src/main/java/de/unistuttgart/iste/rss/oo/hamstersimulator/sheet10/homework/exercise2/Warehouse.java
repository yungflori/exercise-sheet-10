package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet10.homework.exercise2;

import java.util.Optional;

/**
 * Represents a warehouse that can hold a fixed number of items.
 */
public final class Warehouse {
	//@ private instance invariant capacity > 0;
	//@ private instance invariant numberOfItems >= 0;
	//@ private instance invariant numberOfItems <= capacity;
	
	private final int capacity;
	private int numberOfItems;
	//TODO: Add data structures for exercises 2a and 2c
	
	/*@
	  @ requires capacity > 0;
	  @ ensures this.capacity == capacity;
	  @*/
	/**
	 * Creates a new warehouse with the given capacity.
	 * @param capacity Capacity of the warehouse in items.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Warehouse(final int capacity) throws IllegalArgumentException {
		if (capacity <= 0) {
			throw new IllegalArgumentException("A warehouse must have a minimum capacity of 1.");
		}
		this.capacity = capacity;
		numberOfItems = 0;
		//TODO: Initialize data structures for exercises 2a and 2c
	}
	
	public void addItem(final Item item) {
		numberOfItems++;
		//TODO: Exercises 2b and 2d
	}
	
	public void removeItem(final int compartmentNumber) {
		numberOfItems--;
		//TODO: Exercises 2b and 2d
	}
	
	public Optional<Item> getItem(final int compartmentNumber) {
		//TODO: Exercise 2b
		return Optional.empty();
	}
	
	public int getCompartmentNumberOf(final ItemIdentification identification) {
		//TODO: Exercise 2d
		return 0;
	}
	
	/*@
	  @ ensures \result == capacity;
	  @*/
	/**
	 * @return The capacity of this warehouse in items.
	 */
	public /*@ pure @*/ int getCapacity() {
		return capacity;
	}
	
	/*@
	  @ ensures \result == numberOfItems;
	  @*/
	/**
	 * @return The number of items in this warehouse.
	 */
	public /*@ pure @*/ int getNumberOfItems() {
		return numberOfItems;
	}
	
}
