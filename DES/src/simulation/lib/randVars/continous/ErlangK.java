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

	public ErlangK(RNG rng) {
		super(rng);
		// TODO Auto-generated constructor stub
		// we have to di this yes we do
	}

	@Override
	public double getRV() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMean() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getVariance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMean(double m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStdDeviation(double s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMeanAndStdDeviation(double m, double s) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}		
}
