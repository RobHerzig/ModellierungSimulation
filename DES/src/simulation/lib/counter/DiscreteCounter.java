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
		double mean = 0.0;
		mean = getSumPowerOne() / getNumSamples();
		return mean;
	}
	
	/**
	 * @see Counter#getVariance()
	 */
	@Override
	public double getVariance() {
		//Skript 1.4.3 ?!
		double variance = 0.0;
		double x1 = getMean();
		double x2 = getSumPowerTwo() / getNumSamples();
		double nPart = (double)getNumSamples() / (double)(getNumSamples()-1);
		variance = nPart * (x2 - Math.pow(x1, 2));
		return variance;
	}
	
	/**
	 * @see Counter#count(double)
	 */
	@Override
	public void count(double x) {
		super.count(x);

		increaseSumPowerOne(Math.pow(x, 1)); //Could just be x, this is only for better understanding (power one)
		increaseSumPowerTwo(Math.pow(x, 2));
	}
}
