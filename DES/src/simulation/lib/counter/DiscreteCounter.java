package simulation.lib.counter;


/**
 * This class implements a discrete time counter
 */
public class DiscreteCounter extends Counter {

	/**
	 * Basic constructor
	 * @param variable the variable to observe
	 */
	public DiscreteCounter(String variable) {
		super(variable, "counter type: discrete-time counter");
	}
	
	/**
	 * Basic constructor
	 * @param variable the variable to observe
	 */
	protected DiscreteCounter(String variable, String type) {
		super(variable, type);
	}	
	
	/**
	 * @see Counter#getMean()
	 */
	@Override
	public double getMean() {
		/**
		 * TODO Problem 2.1.1 - getMean
		 * Implement this function!
		 * Hint: See course syllabus 1.4.1 ff.
		 */
		double mean = 0.0;
		return mean;
	}
	
	/**
	 * @see Counter#getVariance()
	 */
	@Override
	public double getVariance() {
		/**
		 * TODO Problem 2.1.1 - getVariance
		 * Implement this function!
		 * Hint: See course syllabus 1.4.1 ff.
		 */
		double variance = 0.0;
		return variance;
	}
	
	/**
	 * @see Counter#count(double)
	 */
	@Override
	public void count(double x) {
		super.count(x);
		/**
		 * TODO Problem 2.1.1 - count
		 * Implement this function!
		 * Hint: See course syllabus 1.5.1
		 */
	}
}
