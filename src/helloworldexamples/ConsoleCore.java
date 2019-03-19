package helloworldexamples;

import org.paninij.lang.Capsule;

/**
 * This capsule's entire responsibility is to print messages
 * to the console.
 * 
 * This capsule does not have a state and does not need
 * any other capsules to run.
 * @author Eva Kuntz
 *
 */
@Capsule
class ConsoleCore {
	
	// writeMessage() is a procedure
	void writeMessage(String message) {
		System.out.println(message);
	}
}
