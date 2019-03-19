package examples;

import org.paninij.lang.Capsule;
import org.paninij.lang.Imported;

/**
 * Example of Bar/Worker Panini program.
 * @author Eva Kuntz
 *
 */
@Capsule
class BarCore {
    
    @Imported Worker worker;
    
    void doWork() {
        Foo f = worker.work();
        // do work...
        // ..
        // use Foo
        f.doSomethingOnFoo();
    }

}
