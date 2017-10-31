package study;

import simulation.lib.counter.DiscreteCounter;
import simulation.lib.histogram.DiscreteHistogram;
import simulation.lib.randVars.RandVar;
import simulation.lib.randVars.continous.ErlangK;
import simulation.lib.randVars.continous.Exponential;
import simulation.lib.randVars.continous.HyperExponential;
import simulation.lib.randVars.continous.Uniform;
import simulation.lib.rng.StdRNG;

/*
 * TODO Problem 2.3.3 and 2.3.4[Bonus] - implement this class
 * You can call your test from the main-method in SimulationStudy
 */
public class RandVarTest {

	double mean = 1d;
	double[] cvars = new double[]{0.1d, 1d, 2d};
	RandVar[] rndInstances;
	long n = (long) Math.pow(10, 6);
	DiscreteCounter discreteCounter;
	DiscreteHistogram discreteHistogram;
	
	
	public RandVarTest() {
		//Use instance instead of static functions, looks better to the entity that is our group
		StdRNG rng = new StdRNG();
		rndInstances = new RandVar[] {
				new Uniform(rng),
				new Exponential(rng),
				new ErlangK(rng),
				new HyperExponential(rng)
		};
		discreteCounter = new DiscreteCounter("DiscreteCounter");
		discreteHistogram = new DiscreteHistogram("DiscreteHistogram", 100, 0.0, 10.0);
	}
	
    public void testRandVars() {
    	int testCounter = 1;
    	for (RandVar randVar : rndInstances) {
			System.out.println(randVar.toString());
			
			for (double cvar : cvars) {
				System.out.println("TEST NO: " + testCounter);
	    		testCounter++;
				System.out.println("CVAR = " + cvar);
				
				//Actual test here:
				try {
					randVar.setMeanAndCvar(mean, cvar);
					discreteCounter.reset();
					discreteHistogram.reset();
					
					for(int i = 0; i < n; i++) {
						double rv = randVar.getRV();
						discreteCounter.count(rv);
						discreteHistogram.count(rv);
					}
					
					System.out.println(discreteCounter.report());
					System.out.println(discreteHistogram.report());
					
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				
			}	
		}
    }
    
    public static void main(String[] args) {
		RandVarTest test = new RandVarTest();
		test.testRandVars();
	}
    
}
