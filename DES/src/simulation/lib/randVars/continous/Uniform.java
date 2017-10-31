package simulation.lib.randVars.continous;

import simulation.lib.randVars.RandVar;
import simulation.lib.rng.RNG;

/*
 * TODO Problem 2.3.2 - implement this class (section 3.2.1 in course syllabus)
 * !!! If an abstract class method does not make sense to be implemented in a particular RandVar class,
 * an UnsupportedOperationException should be thrown !!!
 *
 * Uniform distributed random variable.
 */
public class Uniform extends RandVar {
	double mean = 0d;
	double stdDeviation = 0d;
	double variance = 0d;
	
	public Uniform(RNG rng) {
		super(rng);
		// nothing else necessary
	}

	@Override
	public double getRV() {
		double result = 0d;
		//Variance=(a+b)^2/12
		double b = (Math.sqrt(12*variance) + 2d * mean) / 2d;
		//E(x) = (a+b)/2
		double a = 2d * mean - b;
		result = a + (b-a) * rng.rnd(); //3.2.1 'Erzeugung durch Inversion'
		return result;
	}

	@Override
	public double getMean() {
		return mean;
	}

	@Override
	public double getVariance() {
		return variance;
	}

	@Override
	public void setMean(double m) {
		mean = m;
	}

	@Override
	public void setStdDeviation(double s) {
		stdDeviation = s;
		variance = Math.pow(s, 2);
	}

	@Override
	public void setMeanAndStdDeviation(double m, double s) {
		mean = m;
		stdDeviation = s;
		variance = Math.pow(s, 2);
	}

	@Override
	public String getType() {
		String type = "Uniform";
		return type;
	}

	@Override
	public String toString() {
		//Assuming the string should contain all relevant information
		String info = "TYPE: " + getType() + ":\n";
		info += "Mean = " + mean + " StdDev = " + stdDeviation + 
				" Variance = " + variance;
		return info;
	}
	
}
