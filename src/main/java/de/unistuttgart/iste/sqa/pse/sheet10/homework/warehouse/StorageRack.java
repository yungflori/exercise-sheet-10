package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;
import java.util.Optional;

/**
 * Represents a warehouse that can hold a fixed number of items.
 * The number of holdable items is defined by the capacity of the storage rack.
 *
 * @author AmoresSchneyinck
 */
public final class StorageRack {
	// @ private instance invariant capacity > 0;
	// @ private instance invariant numberOfItems >= 0;
	// @ private instance invariant numberOfItems <= capacity;

	private final int capacity;
	private int numberOfItems;
	private final Optional<StationeryItem>[] compartments; // Array of Optional<StationeryItem>

	/*@
	@ requires capacity > 0;
	@ ensures this.capacity == capacity;
	@ ensures numberOfItems == 0;
    @ ensures compartments.length == capacity; // Additional postcondition for array initialization.
	@*/
	/**
	 * Creates a new storage rack with the given capacity.
	 *
	 * @param capacity capacity of the storage rack.
	 *
	 * @throws IllegalArgumentException If capacity is less than 1.
	 */
	public StorageRack(final int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("A warehouse must have a minimum capacity of 1.");
		}
		this.capacity = capacity;
		numberOfItems = 0;
		this.compartments = new Optional[capacity];

		// Initialize each compartment with empty Optional
		for (int i = 0; i < capacity; i++) {
			compartments[i] = Optional.empty();
		}
	}

	/*@
    @ requires stationeryItem != null;
    @ requires numberOfItems < capacity; // Ensure there is space in the rack
    @*/

	/**
	 *
	 *
	 * @param stationeryItem
	 */
	public void addItem(final StationeryItem stationeryItem) {
		// Find the first available storage space (Optional.empty())
		for (int i = 0; i < capacity; i++) {
			if (!compartments[i].isPresent()) {
				compartments[i] = Optional.of(stationeryItem);
				numberOfItems++;
				return; // Stop once an empty compartment is found and the item is added
			}
		}
	}

	// TODO add documentation here.
	public void removeItem(final int compartmentNumber) {
		// TODO implement exercises 1b and 1d here.
	}

	// TODO add documentation here.
	public /*@ pure @*/ Optional<StationeryItem> getItem(final int compartmentNumber) {
		// TODO implement exercise 1b here.
		return Optional.empty(); // TODO delete this line if necessary.
	}

	// TODO add documentation here.
	public /*@ pure @*/ Optional<Integer> getCompartmentNumberOf(final Identifier identifier) {
		// TODO implement exercise 1d here.
		return Optional.empty(); // TODO delete this line if necessary.
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
		return this.numberOfItems;
	}
}
