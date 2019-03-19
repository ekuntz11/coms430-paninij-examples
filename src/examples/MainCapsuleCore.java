package examples;

import org.paninij.lang.Capsule;
import org.paninij.lang.Local;
import org.paninij.lang.Root;

/**
 * This is the main capsule of this
 * particular capsule system.
 */
@Root @Capsule
class MainCapsuleCore {
    @Local Bar bar;
    @Local Worker worker;
    
    // Design declaration that 'wires'
    // the Bar and Worker capsules together
    void design(MainCapsule self) {
        bar.imports(worker);        
    }
    
    // The run procedure will run without needing to
    // be invoked by another capsule.
    void run() {
        bar.doWork();
    }

}
