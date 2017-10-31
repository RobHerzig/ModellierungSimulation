package simulation.lib.randVars.continous;

import simulation.lib.randVars.RandVar;
import simulation.lib.rng.RNG;

/*
 * TODO Problem 2.3.2 - implement this class (section 3.2.3 in course syllabus)
 * !!! If an abstract class method does not make sense to be implemented in a particular RandVar class,
 * an UnsupportedOperationException should be thrown !!!
 *
 * Erlang-k distributed random variable.
 */
public class ErlangK extends RandVar {

	int k = 1;
	double mean = 0d;
	double stdDeviation = 0d;
	double variance = 0d;
	
	public ErlangK(RNG rng) {
		super(rng);
	}
	
	//Additional constructor for setting the k value
	public ErlangK(RNG rng, int _k) {
		super(rng);
		k = _k;
	}

	@Override
	public double getRV() {
		double result = 0d;
		//X = -1/lambda * ln(product_0->k[U_i])
		double lambda = k/mean;
		double product = 1d;
		for (int i = 0; i < k; i++) {
			product *= rng.rnd();
		}
		result = -1/lambda * Math.log(product);
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
		String type = "ErlangK (k=" + k + ")";
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
