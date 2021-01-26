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
	private final Item[] items;
	//TODO: Add data structure for exercise 2c
	
	/*@
	  @ requires capacity > 0;
	  @ ensures this.capacity == capacity;
	  @ ensures items.length == capacity;
	  @*/
	/**
	 * Creates a new warehouse with the given capacity.
	 * @param capacity Capacity of the warehouse in items.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Warehouse(final int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("A warehouse must have a minimum capacity of 1.");
		}
		this.capacity = capacity;
		numberOfItems = 0;
		items = new Item[capacity];
		//TODO: Initialize data structure for exercise 2c
	}
	
	public void addItem(final Item item) {
		//TODO: Exercises 2b and 2d
		numberOfItems++;
	}
	
	public void removeItem(final int compartmentNumber) {
		//TODO: Exercises 2b and 2d
		numberOfItems--;
	}
	
	public Optional<Item> getItem(final int compartmentNumber) {
		//TODO: Exercise 2b
		return Optional.empty();
	}
	
	public Optional<Integer> getCompartmentNumberOf(final ItemIdentification identification) {
		//TODO: Exercise 2d
		return Optional.empty();
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
