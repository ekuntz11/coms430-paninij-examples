package examples;

import java.util.concurrent.Future;

/**
 * Example of Bar/Worker with explicit futures.
 * @author Eva Kuntz
 *
 */
public class WorkerNotCapsule {
    
   public Future<Foo> work() {
        SimpleFuture<Foo> foo = new SimpleFuture<Foo>();
        // ...computation
        // set result        
        foo.set(new Foo());
        return (Future<Foo>)foo;        
    }

}
