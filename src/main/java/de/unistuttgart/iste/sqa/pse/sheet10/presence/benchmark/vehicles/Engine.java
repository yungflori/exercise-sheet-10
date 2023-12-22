package de.unistuttgart.iste.sqa.pse.sheet10.presence.benchmark.vehicles;

/**
 * An Engine that is built into a {@link Vehicle}
 *
 * Each engine has a power value and an ID.
 * The power value must be greater than 0 and the ID must not be empty.
 *
 */
public class Engine {

	private final double power;
	private final String engineId;

	/**
	 * Create a new engine.
	 *
	 * @param power the engine's power.
	 * @param engineId the engine's id.
	 */
	public Engine(final double power, final String engineId) {
		if (power <= 0 || engineId == null || engineId.isEmpty()) {
			throw new IllegalArgumentException("Cannot create Enging with given power value and ID.");
		}
		this.power = power;
		this.engineId = engineId;
	}

	/**
	 * Get the power of the engine.
	 *
	 * @return the power of the engine.
	 */
	public double getPower() {
		return this.power;
	}

	@Override
	public String toString() {
		return engineId;
	}
}
