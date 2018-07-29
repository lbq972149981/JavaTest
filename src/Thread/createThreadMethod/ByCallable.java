package Thread.createThreadMethod;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liubaoqing
 * @createTime 2018-07-23
 * @description
 */
public class ByCallable<E> implements Callable{
   @Override
   public Object call() throws Exception {
      System.out.println(Thread.currentThread().getName());
      return null;
   }
   public static void main(String[] args) {
      Callable<Object> oneCallable = new ByCallable<Object>();
      FutureTask<Object> onefutureTask = new FutureTask<Object>(oneCallable);
      Thread thread = new Thread(onefutureTask);
      thread.setName("myThirdThread");
      thread.start();
      System.out.println(Thread.currentThread());
   }
}
