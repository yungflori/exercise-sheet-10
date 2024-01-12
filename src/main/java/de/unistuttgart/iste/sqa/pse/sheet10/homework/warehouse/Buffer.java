package de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse;

import de.unistuttgart.iste.sqa.pse.sheet10.homework.warehouse.items.StationeryItem;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a buffer for temporary storage of items.
 *
 * @author AmoresSchneyinck
 */
public final class Buffer {

	private final Queue<StationeryItem> itemQueue;

	/**
	 * Creates a new buffer with a Queue for storing items.
	 */
	public Buffer() {
		itemQueue = new LinkedList<>();
	}

	/**
	 * Adds an item to the buffer.
	 *
	 * @param stationeryItem the item to be added to the buffer.
	 */
	public void bufferItem(final StationeryItem stationeryItem) {
		itemQueue.offer(stationeryItem); // Enqueue operation
	}

	/**
	 * Releases an item from the buffer.
	 *
	 * @return the item removed from the buffer, or null if the buffer is empty.
	 */
	public StationeryItem releaseItem() {
		return itemQueue.poll(); // Dequeue operation
	}

	/**
	 * Checks if the buffer is empty.
	 *
	 * @return true if the buffer is empty, false otherwise.
	 */
	public /*@ pure @*/ boolean isEmpty() {
		return itemQueue.isEmpty();
	}
}
