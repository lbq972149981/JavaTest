package Thread.createThreadMethod;

import java.util.concurrent.*;

/**
 * @author liubaoqing
 * @createTime 2018-07-23
 * @description
 */
public class ByThreadPool implements Callable{
   private String name;
   private static int POOL_NUM = 10;
   public ByThreadPool(String name){
      this.name = name;
   }
   public static void main(String[] args) throws ExecutionException, InterruptedException {
      FutureTask futureTask = null;
      ExecutorService service = Executors.newFixedThreadPool(5);
      for(int i=0;i<POOL_NUM;i++){
         futureTask = new FutureTask(new ByThreadPool("a"+i));
         service.submit(futureTask);
         System.out.println(futureTask.get());
      }
      service.shutdown();
   }
   @Override
   public Object call() throws Exception {
      System.out.println(this.name);
      return Thread.currentThread();
   }
}
