package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liubaoqing
 * @createTime 2018-07-20
 * @description
 */
public class CountDownLatchTest {
   public static CountDownLatch countDownLatch = new CountDownLatch(10);//初始化计数值
   public static void main(String[] args) {
      ExecutorService executor = Executors.newCachedThreadPool();//FixedThreadPool(10);
      for(int i=1;i<=30;i++){
         executor.submit(new Thread(new Runner1(i+"号选手")));
      }
      executor.shutdown();
   }
}
class Runner1 implements Runnable{
   private String name;
   public Runner1(String name){
      this.name = name;
   }
   @Override
   public void run() {
      System.out.println(name + "准备好了。");
      CountDownLatchTest.countDownLatch.countDown();  //计数值减1
      try {
         CountDownLatchTest.countDownLatch.await();
      } catch (Exception e) {
      }
      System.out.println(name + "起跑！");
   }
}
