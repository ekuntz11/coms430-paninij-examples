package pi;

import org.paninij.lang.Capsule;
import org.paninij.lang.Local;
import org.paninij.lang.Root;

//This is the root capsule
@Root @Capsule
class PiCore {    
    final int SAMPLE_SIZE = 100000000;
    final int WORKER_COUNT = 10;
    
	@Local Worker[] workers = new Worker[WORKER_COUNT];
	
	void run() {
		Number[] results = new Number[WORKER_COUNT]; //results from our worker computations
		double total = 0;
		double numIterations = SAMPLE_SIZE / WORKER_COUNT;
		
		long start = System.currentTimeMillis(); //timer
		
		for(int i = 0; i < WORKER_COUNT; i++) {
			//create and start worker capsules
			results[i] = workers[i].compute(numIterations);
		}
		
		//get results
		//this will block if the value has not been computed yet
		for(Number num : results) {
			total += num.getValue();
		}
		
		double pi = 4.0 * total / SAMPLE_SIZE;
		long elapsed = System.currentTimeMillis() - start;
		
		System.out.println("Estimate for pi using " + SAMPLE_SIZE + " is: " + pi);
		System.out.println("Elapsed time was: " + elapsed + "ms");
	}
	
	

}
