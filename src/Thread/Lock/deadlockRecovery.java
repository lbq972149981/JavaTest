package Thread.Lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author liubaoqing
 * @createTime 2018-07-24
 * @description
 */
public class deadlockRecovery {
   public static void main(String[] args) {
      Semaphore semaphore1 = new Semaphore(1);
      Semaphore semaphore2 = new Semaphore(1);
      new Thread(new workThread1(semaphore1,semaphore2)).start();
      new Thread(new workThread2(semaphore1,semaphore2)).start();
      //使死锁恢复
//      semaphore1.release();
//      semaphore2.release();
   }
}
class workThread1 implements Runnable{
   private Semaphore semaphore1,semaphore2;
   public workThread1(Semaphore semaphore1, Semaphore semaphore2) {
      this.semaphore1 = semaphore1;
      this.semaphore2 = semaphore2;
   }
   @Override
   public void run() {
      try {
         semaphore2.acquire();//先获取Semaphore2
         System.out.println(Thread.currentThread().getId()+"-获得semaphore2");
         TimeUnit.SECONDS.sleep(5);//等待5秒，让WorkThread1先获得Semaphore1
//         semaphore2.release();
         semaphore1.acquire();
         System.out.println(Thread.currentThread().getId()+"-获得semaphore1");
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
class workThread2 implements Runnable{
   private Semaphore semaphore1,semaphore2;
   public workThread2(Semaphore semaphore1, Semaphore semaphore2) {
      this.semaphore1 = semaphore1;
      this.semaphore2 = semaphore2;
   }
   @Override
   public void run() {
      try {
         semaphore1.acquire();//先获取Semaphore2
         System.out.println(Thread.currentThread().getId()+"-获得semaphore1");
         TimeUnit.SECONDS.sleep(5);//等待5秒，让WorkThread1先获得Semaphore1
//         semaphore1.release();
         semaphore2.acquire();
         System.out.println(Thread.currentThread().getId()+"-获得semaphore2");
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}