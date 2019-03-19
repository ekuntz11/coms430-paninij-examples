package helloworldexamples;

import org.paninij.lang.Capsule;
import org.paninij.lang.Local;
import org.paninij.lang.Root;

import helloworldexamples.Console;
import helloworldexamples.Greeter;

/**
 * Due to the 'run' declaration in this capsule,
 * the HelloWorld capsule is the active capsule
 * in this capsule system.
 * 
 * Active capsules do not have any procedures.
 * The main responsibility of an active capsule is to 'drive'
 * the other capsules in the capsule system.
 * 
 * The Panini runtime will execute the 'run' procedure
 * of the active capsule. As such, the active capsule
 * does not need to be invoked by any other capsule. 
 * 
 * @author Eva Kuntz
 *
 */
@Root @Capsule
class HelloWorldCore {
	// @Local indicates that, for every instance
	// of HelloWorld, the runtime should also
	// instantiate an instance of Console and Greeter. 
	@Local Console c;
	@Local Greeter g;
	
	//Design declaration states that in order for Greeter to work
	//correctly, it needs a Console instance.
	void design(HelloWorld self) {
		g.imports(c);
	}
	
	void run() {
		g.greet();
		return;
	}	
	
}
