package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import java.util.Optional;

/**
 * Represents a warehouse that can hold a fixed number of items.
 * 
 * @author your name
 */
public final class Warehouse {
	// @ private instance invariant capacity > 0;
	// @ private instance invariant numberOfItems >= 0;
	// @ private instance invariant numberOfItems <= capacity;

	private final int capacity;
	private int numberOfItems;
	// TODO: Add data structures for exercises 1a and 1c

	/*@
	@ requires capacity > 0;
	@ ensures this.capacity == capacity;
	@*/

	/**
	 * Creates a new warehouse with the given capacity.
	 *
	 * @param capacity Capacity of the warehouse in items.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Warehouse(final int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("A warehouse must have a minimum capacity of 1.");
		}
		this.capacity = capacity;
		this.numberOfItems = 0;
		// TODO: Initialize data structures for exercises 1a and 1c
	}

	public void addItem(final Item item) {
		// TODO: Exercises 1b and 1d
		this.numberOfItems++;
	}

	public void removeItem(final int compartmentNumber) {
		// TODO: Exercises 1b and 1d
		this.numberOfItems--;
	}

	public Optional<Item> getItem(final int compartmentNumber) {
		// TODO: Exercise 1b
		return Optional.empty();
	}

	public Optional<Integer> getCompartmentNumberOf(final ItemIdentification identification) {
		// TODO: Exercise 1d
		return Optional.empty();
	}

	/*@
	@ ensures \result == capacity;
	@*/

	/**
	 * @return The capacity of this warehouse in items.
	 */
	public /*@ pure @*/ int getCapacity() {
		return this.capacity;
	}

	/*@
	@ ensures \result == numberOfItems;
	@*/

	/**
	 * @return The number of items in this warehouse.
	 */
	public /*@ pure @*/ int getNumberOfItems() {
		return this.numberOfItems;
	}
}
