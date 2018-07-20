package concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liubaoqing
 * @createTime 2018-07-20
 * @description
 */
public class CyclicBarrierTest {
   public static CyclicBarrier barrier = new CyclicBarrier(10);
   public static void main(String[] args) {
      ExecutorService executor = Executors.newCachedThreadPool();//FixedThreadPool(10);
      for(int i=1;i<=30;i++){
         executor.submit(new Thread(new Runner(i+"号选手")));
      }
      executor.shutdown();
   }
}
class Runner implements Runnable{
   private String name;
   public Runner(String name) {
      this.name = name;
   }
   @Override
   public void run() {
      System.out.println(name + "准备好了。");
      try {
         //此处就是公共屏障点，所有线程到达之后，会释放所有等待的线程
         CyclicBarrierTest.barrier.await();

      } catch (Exception e) {
      }
      System.out.println(name + "起跑！");
   }
}

