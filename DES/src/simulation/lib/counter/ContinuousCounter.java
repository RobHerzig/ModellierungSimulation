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
		double mean = 0.0;
		mean = sumPowerOne / (lastSampleTime - firstSampleTime);
		return mean;
	}
	
	/**
	 * @see Counter#getVariance()
	 */
	@Override
	public double getVariance() {
		double variance = 0.0;
		variance = sumPowerTwo / (lastSampleTime - firstSampleTime);
		return variance;
	}

	/**
	 * @see Counter#count(double)
	 */
	@Override
	public void count(double x) {
		super.count(x);
		if(getNumSamples() > 1) {
			//Multiple samples available
			long timeDifference = sim.getSimTime() - lastSampleTime;
			//k=1
			double sigmaK1 = lastSampleSize * timeDifference;
			increaseSumPowerOne(sigmaK1);
			//k=2
			double sigmaK2 = Math.pow(lastSampleSize, 2) * timeDifference;
			increaseSumPowerTwo(sigmaK2);
			//refresh values
			lastSampleTime = sim.getSimTime();
			lastSampleSize = x;
		} else {
			//Only one sample
			lastSampleTime = sim.getSimTime();
			firstSampleTime = sim.getSimTime();
			lastSampleSize = x;
		}
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
