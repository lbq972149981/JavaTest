package Thread.counter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liubaoqing
 * @createTime 2018-07-24
 * @description
 */
public class Counter {
   private static AtomicInteger counter = new AtomicInteger(0);//使用原子操作类
   private static CountDownLatch countDownLatch = new CountDownLatch(30);//等待计算线程执行完
   public static void main(String[] args) throws InterruptedException {
      for(int i=0;i<30;i++){
         new Thread(){
            @Override
            public void run() {
               for(int i=0;i<10000;i++){
                  counter.incrementAndGet();//原子性的num++,通过循环CAS方式
               }
               countDownLatch.countDown();
            }
         }.start();
      }
      countDownLatch.await();
      System.out.println(counter);
   }
}
