package simulation.lib.counter;

import simulation.lib.Simulator;

/**
 * This class implements a continuous time counter / time weighted counter
 */
public class ContinuousCounter extends Counter {
	private long lastSampleTime;
	private long firstSampleTime;
	private double lastSampleSize;
	private Simulator sim;
	
	/**
	 * Constructor
	 * @param variable the variable to observe
	 * @param sim the considered simulator
	 */	
	public ContinuousCounter(String variable, Simulator sim) {
		super(variable, "counter type: continuous-time counter");
		this.sim = sim;
	}
	
	/**
	 * @see Counter#getMean()
	 */
	@Override
	public double getMean() {
		/**
		 * TODO Problem 2.1.1 - getMean
		 * Implement this function!
		 * Hint: See course syllabus 1.5.3.2
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
		 * Hint: See course syllabus 1.5.3.2 and 1.4.1 ff.
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
		 * Update the counter's internal data for the calculation of empirical moments
		 * Also update lastSampleSize and lastSampleTime
		 * Hint: See course syllabus 1.5.3.2
		 */
	}

	/**
	 * @see Counter#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		firstSampleTime = sim.getSimTime();
		lastSampleTime = sim.getSimTime();
		lastSampleSize = 0;
	}
}
