package simulation.lib.rng;

import java.util.Random;

/**
 * Standard random number generator
 */
public class StdRNG extends RNG {
	Random rng;
	
	public StdRNG() {
		super();
	}
	/**
	 * Constructor with current milliseconds as seed
	 * @param currentTimeMillis
	 */
	public StdRNG(long currentTimeMillis) {
		super(currentTimeMillis);
	}

	/**
	 * @see RNG#setSeed(long)
	 */
	@Override
	public void setSeed(long seed) {
		rng = new Random(seed);
	}

	/**
	 * @see RNG#rnd()
	 */
	@Override
	public double rnd() {
		double rv = 0;
		rv = rng.nextDouble();
		return rv;
	}
}
