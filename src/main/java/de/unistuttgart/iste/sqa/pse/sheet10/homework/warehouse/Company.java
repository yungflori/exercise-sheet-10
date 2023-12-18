package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import java.util.Optional;
import java.util.Random;

/**
 * Represents the company from homework exercise 2.
 * 
 * @author your name
 */
public final class Company {

	private final Warehouse penWarehouse;
	private final Warehouse triangleRulerWarehouse;
	private final Warehouse compassWarehouse;
	private final Buffer orderBuffer;
	// TODO: Add data structure for exercise 1i

	public Company() {
		orderBuffer = new Buffer();
		// TODO: Exercises 1e and 1i
		penWarehouse = triangleRulerWarehouse = compassWarehouse = null;
	}

	public void handleIncomingItem(final Item item) {
		// TODO: Exercise 1e
	}

	public void processIncomingOrder(final ItemIdentification identification, final Customer customer) {
		// TODO: Exercises 1h and 1i
	}

	/*@
	@ ensures \result != null;
	@ ensures \result.getIdentification().getType() == ItemType.PRESENT;
	@*/

	/**
	 * Generates a marketing present item for exercise 2i.
	 *
	 * @return A marketing present item.
	 */
	private /*@ pure @*/ Item getPresent() {
		ItemType type = ItemType.PRESENT;
		int itemNumber = new Random().nextInt();
		ItemIdentification identification = new ItemIdentification(type, itemNumber);
		return new Item(identification);
	}

	/*@
	@ ensures \old(orderBuffer.isEmpty()) <==> \result.isEmpty();
	@*/

	/**
	 * Takes the next available item for packaging and returns it.
	 *
	 * @return Optional next available item for packaging, or an empty Optional if there is none.
	 */
	public Optional<Item> takeItemForPackaging() {
		if (orderBuffer.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(orderBuffer.releaseItem());
		}
	}

	/*@
	@ requires type != null;
	@*/
	/**
	 * Returns the warehouse in which items of the given type are stored.
	 *
	 * @param type Type for which to get the warehouse.
	 * @return An Optional containing the warehouse for items of the given type, or an empty Optional if there is none.
	 */
	private /*@ pure @*/ Optional<Warehouse> getWarehouseOf(final ItemType type) {
		assert type != null;
		final Optional<Warehouse> warehouse;
		switch (type) {
			case PEN:
				warehouse = Optional.of(penWarehouse);
				break;
			case TRIANGLE_RULER:
				warehouse = Optional.of(triangleRulerWarehouse);
				break;
			case COMPASS:
				warehouse = Optional.of(compassWarehouse);
				break;
			default:
				warehouse = Optional.empty();
		}
		return warehouse;
	}
}
