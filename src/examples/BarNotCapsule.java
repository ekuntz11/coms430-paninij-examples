package examples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class BarNotCapsule {
    
    private WorkerNotCapsule worker;
    
    void doWork() throws InterruptedException, ExecutionException {
        Future<Foo> futureFoo = worker.work();
        //.. do compuation
        // use foo
        Foo f = futureFoo.get();
        f.doSomethingOnFoo();
    }

}
