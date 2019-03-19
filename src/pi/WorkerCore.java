package pi;

import java.util.Random;
import org.paninij.lang.Capsule;

@Capsule
class WorkerCore {
	Random prng;
	
	void init() {
		this.prng = new Random();
	}
	
	Number compute(double numIterations) {
		Number circleCount = new Number(0);
		System.out.println(Thread.currentThread().getName() + " " + numIterations);
		
		for(int i = 0; i < numIterations; i++) {
			double x = this.prng.nextDouble();
			double y = this.prng.nextDouble();
			
			if((x*x + y*y) < 1) {
				//if inside unit circle, increment circle count
				circleCount.increment();
			}
		}
		
		return circleCount;
	}
}
