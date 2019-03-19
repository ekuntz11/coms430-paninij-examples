package helloworldexamples;

import org.paninij.lang.Capsule;
import org.paninij.lang.Imported;

import helloworldexamples.Console;

/**
 * This capsule's responsibility is to write a specific
 * greeting to the console using the Console capsule.
 * 
 * The Greeter capsule does not have a state, but
 * does need an instance of the Console capsule to work correctly.
 * @author Eva Kuntz
 */
@Capsule
class GreeterCore {
	
	// @Imported annotation indicates that in order for
	// Greeter to work correctly, it will need to be provided
	// with an instance of Console. Note that the proper 'wiring'
	// will be done by another capsule (in this case, wiring is
	// done by the Design declaration in the HelloWorld capsule).
	@Imported Console c;
	
	//greet() is a procedure
	void greet() {
	    String message = "Hello World, Panini Style!";
		c.writeMessage(message);
	}
}
