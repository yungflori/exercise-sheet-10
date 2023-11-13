package de.unistuttgart.iste.sqa.pse.sheet10.presence.benchmark;

import de.unistuttgart.iste.sqa.pse.sheet10.presence.benchmark.vehicles.Vehicle;

/**
 * A single test run.
 * A test run puts a vehicle with the defined velocity onto testroute and checks how far the vehicle gets.
 * If the vehicle completes the testroute, the test run is a success. 
 * Otherwise, it is a failure.  
 */
public final class TestRun {
	
	private final TestRoute route;
	private final Vehicle vehicle;
	private double result;
	
	/*@
	 @ requires route != null && vehicle != null;
	 @*/
	/**
	 * Create a new {@code TestRun}.
	 * 
	 * @param route the route to test on
	 * @param vehicle the vehicle to be tested 
	 */
	public TestRun(final TestRoute route, final Vehicle vehicle) {
		if (route == null || vehicle == null) {
			throw new IllegalArgumentException("Cannot create TestRun with given route and verhicle.");
		}
		this.route = route;
		this.vehicle = vehicle;
		this.result = -1;
	}

	/**
	 * Execute the TestRun.
	 */
	public void executeTest() {
		result = vehicle.getPerformance() / route.velocity();
	}

	/**
	 * Determine, whether the vehicle completed the route successfully or not.
	 *
	 * @return true, iff the test ran and the vehicle completed the route. 
	 */
	public Boolean testSucceded() {
		return result != -1 && result < route.length();
	}
}
