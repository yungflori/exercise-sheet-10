package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Compass;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Pen;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Ruler;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;
import java.util.Optional;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

	/**
 	* Represents a company.
 	* A company stores items and processes orders.
 	*
	 * @author AmoresSchneyinck
 	*/
	public final class Company {

		private final StorageRack itemStorageRack;
		private final Buffer orderBuffer;
		private final Set<Customer> knownCustomers;

	/**
	 * Creates a new company with a storage rack and an order buffer.
	 */
	public Company() {
		orderBuffer = new Buffer();
		// Initialize the itemStorageRack with a new StorageRack instance
		itemStorageRack = new StorageRack(75); // Assuming a maximum of 75 individual items can be stored.
		knownCustomers = new HashSet<>();

	}

	/**
	 * Places the individual item in the warehouse.
	 *
	 * @param stationeryItem the item to be placed in the warehouse.
	 */
	public void storeInStorageRack(final StationeryItem stationeryItem) {
		// Check if there is space in the warehouse
		if (itemStorageRack.getNumberOfItems() < itemStorageRack.getCapacity()) {
			// Add the item to the warehouse
			itemStorageRack.addItem(stationeryItem);
		}
		// If no space is available, ignore the item.
	}

	/**
	 * Processes an incoming order by removing the individual item with the given identifier
	 * from its compartment in the storage rack and adding it to the order buffer.
	 *
	 * If the given individual item is not in the warehouse, the order is ignored.
	 *
	 * All new customers receive a promotional gift.
	 *
	 * @param identifier the identifier of the item in the order.
	 * @param customer   the customer placing the order.
	 */
	public void processIncomingOrder(final Identifier identifier, final Customer customer) {
		// Check if the customer is already known
		if (!knownCustomers.contains(customer)) {
			// New customer, provide a promotional gift
			StationeryItem promotionalGift = getBonusItem();
			storeInStorageRack(promotionalGift);
			knownCustomers.add(customer); // Mark the customer as known
		}

		// Get the compartment number for the given identifier
		Optional<Integer> compartmentNumber = itemStorageRack.getCompartmentNumberOf(identifier);

		// Check if the identifier is found in the warehouse
		if (compartmentNumber.isPresent()) {
			// Remove the item from the compartment and add it to the order buffer
			Optional<StationeryItem> item = itemStorageRack.getItem(compartmentNumber.get());
			itemStorageRack.removeItem(compartmentNumber.get());

			// Buffer the item if it is present
			item.ifPresent(orderBuffer::bufferItem);
		}
		// If the identifier is not found in the warehouse, ignore the order.
	}


	/*@
	@ ensures \result != null;
	@ ensures \result.getIdentification().getType() == ItemType.PRESENT;
	@*/
	/**
	 * Generates a bonus item for marketing reasons.
	 *
	 * @return A marketing bonus item.
	 */
	private /*@ pure @*/ StationeryItem getBonusItem() {

		switch ((new Random().nextInt(3))) {
			case 1:
				return new Compass(new Identifier(), "A marketing bonus item.");
			case 2:
				return new Ruler(new Identifier(), "A marketing bonus item.");
			default:
				return new Pen(new Identifier(), "A marketing bonus item.");
		}
	}

	/**
	 * If items are waiting for packaging, takes the next available item from the buffer and return it.
	 *
	 * @return Optional next available item for packaging, or an empty Optional if there is none.
	 */
	public Optional<StationeryItem> takeItemForPackaging() {
		if (orderBuffer.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(orderBuffer.releaseItem());
		}
	}
}
