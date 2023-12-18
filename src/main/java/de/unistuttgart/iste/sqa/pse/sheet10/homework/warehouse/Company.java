package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Compass;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Pen;
import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.Ruler;

/**
 * Represents a company.
 *
 * A company stores items and processes orders.
 *
 * @author your name
 */
public final class Company {

	private final StorageRack itemStorageRack;
	private final Buffer orderBuffer;
	// TODO: Add data structure for exercise 1i here.

	// TODO add documentation here.
	public Company() {
		orderBuffer = new Buffer();
		// TODO: implement exercises 1e and 1i here.
		itemStorageRack = null; // TODO delete this line if necessary
	}

	// TODO add documentation here.
	public void storeInStorageRack(final StationeryItem stationeryItem) {
		// TODO: implement exercise 1e here.
	}

	// TODO add documentation here.
	public void processIncomingOrder(final Identifier identifier, final Customer customer) {
		// TODO implement exercises 1h and 1i here.
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
