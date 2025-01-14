package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;
import java.util.Optional;
import java.util.HashMap;

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
	private final HashMap<Identifier, Integer> identifierToCompartmentMap;

    /*@
    @ requires capacity > 0;
    @ ensures this.capacity == capacity;
    @ ensures numberOfItems == 0;
    @ ensures compartments.length == capacity; // Additional post-condition for array initialization.
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
		this.identifierToCompartmentMap = new HashMap<>();

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
	 * Adds a stationery item to the storage rack.
	 *
	 * @param stationeryItem the item to be added.
	 */
	public void addItem(final StationeryItem stationeryItem) {
		// Find the first available storage space (Optional.empty())
		for (int i = 0; i < capacity; i++) {
			if (compartments[i].isEmpty()) {
				// Store the item in the compartment
				compartments[i] = Optional.of(stationeryItem);
				numberOfItems++;

				// Store the mapping in identifierToCompartmentMap
				Identifier identifier = stationeryItem.getIdentifier();
				identifierToCompartmentMap.put(identifier, i);

				return; // Stop once an empty compartment is found and the item is added
			}
		}
	}


	/**
	 * Removes the individual item at the given storage space from the data structure of the storage rack.
	 * If the individual item is not present, nothing happens.
	 *
	 * @param compartmentNumber the compartment number from which to remove the item.
	 */
	public void removeItem(final int compartmentNumber) {
		// Check if the compartmentNumber is valid
		if (compartmentNumber >= 0 && compartmentNumber < capacity) {
			Optional<StationeryItem> optionalItem = compartments[compartmentNumber];

			// Check if the compartment contains an item
			if (optionalItem.isPresent()) {
				// Retrieve the identifier of the item to be removed
				Identifier identifier = optionalItem.get().getIdentifier();

				// Remove the item by replacing it with an empty Optional
				compartments[compartmentNumber] = Optional.empty();
				numberOfItems--;

				// Delete the mapping from identifierToCompartmentMap
				identifierToCompartmentMap.remove(identifier);
			}
			// If the compartment is already empty, do nothing
		}
		// If compartmentNumber is invalid (negative or greater than or equal to capacity), do nothing
	}

	/**
	 * Returns the individual item at the given storage space.
	 *
	 * @param compartmentNumber the compartment number from which to retrieve the item.
	 * @return an Optional containing the individual item if present, or an empty Optional if the compartment is empty.
	 */
	public /*@ pure @*/ Optional<StationeryItem> getItem(final int compartmentNumber) {
		// Check if the compartmentNumber is valid
		if (compartmentNumber >= 0 && compartmentNumber < capacity) {
			return compartments[compartmentNumber];
		}
		// If compartmentNumber is invalid (negative or greater than or equal to capacity), return empty Optional
		else return Optional.empty();
	}

	// TODO add documentation here.
    /*@
    @ requires identifier != null;
    @*/
	/**
	 * Returns the compartment number where the item with the given identifier is stored.
	 *
	 * @param identifier the identifier of the item.
	 * @return an Optional containing the compartment number if the item is found,
	 *         or an empty Optional if the item is not in the warehouse.
	 */
	public Optional<Integer> getCompartmentNumberOf(final Identifier identifier) {
		if (identifierToCompartmentMap.containsKey(identifier)) {
			int compartmentNumber = identifierToCompartmentMap.get(identifier);
			return Optional.of(compartmentNumber);
		} else return Optional.empty();
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
