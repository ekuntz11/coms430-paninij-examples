package examples;

import org.paninij.lang.Capsule;


/**
 * Example of Bar/Worker Panini program.
 * @author Eva Kuntz
 *
 */
@Capsule
class WorkerCore {
    
    Foo work() {
        Foo f = new Foo();
        // do computation
        // ...
        System.out.println("I am the Worker doing work to create Foo!");
        return f;
    }

}
