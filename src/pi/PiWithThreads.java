package pi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Approximates PI using the Monte Carlo method.  Demonstrates
 * use of Callables, Futures, and thread pools.
 */
public class PiWithThreads 
{
  private static final int numThreads = 8;
  //private static final int numThreads = 1;
  
  private static final int numSamples = 100000000;

  public static void main(String[] args) throws Exception 
  {
    // numThreads workers, numIterations each
    int numIterations = numSamples / numThreads;
    new Master().doRun(numIterations, numThreads);
  }
}

/**
 * Creates workers to run the Monte Carlo simulation
 * and aggregates the results.
 */
class Master {
  public void doRun(int numIterations, int numWorkers) throws InterruptedException, ExecutionException 
  {
    // Create a collection of tasks
    List<Callable<Long>> tasks = new ArrayList<Callable<Long>>();
    for (int i = 0; i < numWorkers; ++i) 
    {
      tasks.add(new WorkerWithThreads(numIterations));
    }
    
    // Run them and receive a collection of Futures
    ExecutorService exec = Executors.newFixedThreadPool(numWorkers);
    
    long start = System.currentTimeMillis();
    List<Future<Long>> results = exec.invokeAll(tasks);
    long total = 0;
    
    // Assemble the results.
    for (Future<Long> f : results)
    {
      // Call to get() is an implicit barrier.  This will block
      // until result from corresponding worker is ready.
      total += f.get();
    }
    double pi =  4.0 * total / numIterations / numWorkers;

    long elapsed = System.currentTimeMillis() - start;

    System.out.println("Pi : " + pi);
    System.out.println(elapsed);
    exec.shutdown();
  }
}

/**
 * Task for running the Monte Carlo simulation.
 */
class WorkerWithThreads implements Callable<Long> 
{   
  private int numIterations;
  public WorkerWithThreads(int num) 
  { 
    this.numIterations = num; 
  }

  @Override
  public Long call() 
  {
    System.out.println(Thread.currentThread().getName() + " " + numIterations);
    long circleCount = 0;
    Random prng = new Random ();
    for (int j = 0; j < numIterations; j++) 
    {
      double x = prng.nextDouble();
      double y = prng.nextDouble();
      if ((x * x + y * y) < 1) 
      {
        ++circleCount;
      }
    }
    return circleCount;
  }
}


