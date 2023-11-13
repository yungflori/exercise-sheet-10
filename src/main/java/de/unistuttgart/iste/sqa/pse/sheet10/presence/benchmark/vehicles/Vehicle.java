package de.unistuttgart.iste.sqa.pse.sheet10.presence.benchmark.vehicles;

/**
 * A general vehicle. 
 * 
 */
public interface Vehicle {

	/**
	 * Access the total weight of the vehicle. 
	 * 
	 * If a vehicle transport freight, the weight of the freight, is also included into the vehicle's total weight.
	 * 
	 * @return total weight of the vehicle.
	 */
	public double getWeight();
	
	/**
	 * Access the engine of the vehicle.
	 * 
	 * @return the engine of the vehicle.
	 */
	public Engine getEngine();
	
	/**
	 * Access the performance value of the vehicle.
	 * 
	 * The performance value is calculated based on the vehicles weight and the power its engine. 
	 * 
	 * @return the performance value of the vehicle.
	 */
	public double getPerformance();
}