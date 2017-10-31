package simulation.lib.randVars.continous;

import simulation.lib.randVars.RandVar;
import simulation.lib.rng.RNG;
import static java.lang.Math.*;

/*
 * TODO Problem 2.3.2 - implement this class (section 3.2.4 in course syllabus)
 * !!! If an abstract class method does not make sense to be implemented in a particular RandVar class,
 * an UnsupportedOperationException should be thrown !!!
 *
 * Hyperexponential distributed random variable.
 */
public class HyperExponential extends RandVar {

	double mean = 0d;
	double stdDeviation = 0d;
	double variance = 0d;
	double cVar = 0d;
	double lambda1 = 0d;
	double lambda2 = 0d;
	
	public HyperExponential(RNG rng) {
		super(rng);
	}
	
	public HyperExponential(RNG rng, double _cVar, double _mean) {
		super(rng);
		mean = _mean;
		cVar = _cVar;
		setLambdas();
	}

	@Override
	public double getRV() {
		double result = 0d;
		Exponential expObject0 = new Exponential(rng);
		Exponential expObject1 = new Exponential(rng);
		double p0 = expObject0.getRV();
		double p1 = expObject1.getRV();
		
		while((p0/lambda1 != p1/lambda2) && (p0 + p1 != 1d)) {
			p0 = expObject0.getRV();
			p1 = expObject1.getRV();
		}
		
		result = p0 / lambda1 + p1 / lambda2;
		
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
		cVar = stdDeviation/mean;
		if (cVar != 1d) {
			throw new IllegalArgumentException("UNACCEPTABLE MEAN AND STD-DEVIATION FOR HYPEREXP.");
		}
		setLambdas();
	}
	
	public void setLambdas() {
		double lambdaSquareRootPart = Math.sqrt((Math.pow(cVar, 2)-1d)/(Math.pow(cVar, 2)+1d));
		lambda1 = 1/mean * (1+lambdaSquareRootPart);
		lambda2 = 1/mean * (1-lambdaSquareRootPart);
	}

	@Override
	public String getType() {
		String type = "Hyperexponential";
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
