package Thread.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liubaoqing
 * @createTime 2018-07-25
 * @description
 */
public class ThreadLocalTest {
   public static void main(String[] args) throws InterruptedException {
      ThreadLocalUse user = new ThreadLocalUse();
      Thread thread1 = new Thread(user);
      Thread thread2 = new Thread(user);
      thread1.start();
      thread2.start();
   }
}
class ThreadLocalUse implements Runnable{
   private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
   private Integer local = 0;
   @Override
   public void run() {
      threadLocal.set((int)(Math.random()*100));
      local = (int)(Math.random()*100);
      try {
         Thread.currentThread().sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getId()+":threadLocal:"+threadLocal.get());
      System.out.println(Thread.currentThread().getId()+":local:"+local);
   }
}
