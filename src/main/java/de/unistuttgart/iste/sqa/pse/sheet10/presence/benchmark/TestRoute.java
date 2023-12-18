package de.unistuttgart.iste.sqa.pse.sheet10.presence.benchmark;

/**
 * A test route to test a vehicle on. 
 * 
 * A test route has a lenght in km and a velocity in km/h. Both values must be greater than zero. 
 * In addition, a test route has a name, that must not be empty. 
 */
public record TestRoute(int length, double velocity, String name) {
	
	/**
	 * Create a new TestRoute
	 * 
	 * @param length the route's length
	 * @param velocity the velocity to use on the route
	 * @param name the route's name
	 */
	public TestRoute(final int length, final double velocity, final String name) {
		if (length <= 0 || velocity <= 0 || name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Cannot create TestRoute with given length, velocity and name.");
		}
		
		this.length = length;
		this.velocity = velocity;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("%s [velocity = %f, length = %d]", this.name, this.velocity, this.length);
	}
}