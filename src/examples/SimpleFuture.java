package examples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Bare-bones implementation of a nonexecutable Future.
 * @param <V>
 */
public class SimpleFuture<V> implements Future<V>
{
  private V result;
  private Throwable e;
  
  @Override
  public synchronized V get() throws InterruptedException, ExecutionException
  {
    while (result == null && e == null)
    {
      wait();
    }
    if (result != null)
    {
      return result;
    }
    else
    {
      throw new ExecutionException(e);
    }
  }
  
  /**
   * Sets the result value of this future.
   * @param result
   *   value to set
   */
  public synchronized void set(V result)
  {
    this.result = result;
    notifyAll();
  }
  
  /**
   * Sets the exception value of this future.  Pending or subsequent
   * calls to get() will throw the given exception wrapped in an 
   * <code>ExecutionException</code>
   * @param e
   *   exception to be thrown
   */
  public synchronized void setException(Throwable e)
  {
    this.e = e;
    notifyAll();
  }
  
  @Override
  public synchronized boolean isDone()
  {
    return result != null || e != null;
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    // not implemented
    return false;
  }

  @Override
  public boolean isCancelled()
  {
    // not implemented
    return false;
  }

  @Override
  public V get(long timeout, TimeUnit unit) throws InterruptedException,
      ExecutionException,
      TimeoutException
  {
    // not implemented
    return null;
  }
}

