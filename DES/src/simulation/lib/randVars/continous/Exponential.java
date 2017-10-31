/**
 * 
 */
package simulation.lib.randVars.continous;

import simulation.lib.randVars.RandVar;
import simulation.lib.rng.RNG;

/*
 * TODO Problem 2.3.2 - implement this class (section 3.2.2 in course syllabus)
 * !!! If an abstract class method does not make sense to be implemented in a particular RandVar class,
 * an UnsupportedOperationException should be thrown !!!
 *
 * Expnential distributed random variable.
 */
public class Exponential extends RandVar {
	double mean = 0d;
	double stdDeviation = 0d;
	double variance = 0d;

	public Exponential(RNG rng) {
		super(rng);
	}

	@Override
	public double getRV() {
		double result;
		
		//E[X] = 1/lambda, X = -ln(U)/lambda
		//-> lambda = 1/E[X] -> X = -ln(U) * E[X]
		result = - Math.log(rng.rnd()) * mean;
		
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
		variance = Math.pow(stdDeviation, 2);
	}

	@Override
	public void setMeanAndStdDeviation(double m, double s) {
		mean = m;
		stdDeviation = s;
		variance = Math.pow(stdDeviation, 2);
	}

	@Override
	public String getType() {
		String type = "Exponential";
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
