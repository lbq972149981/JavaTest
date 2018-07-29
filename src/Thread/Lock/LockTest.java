package Thread.Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liubaoqing
 * @createTime 2018-07-24
 * @description
 */
public class LockTest {
   public static void main(String[] args) {
      Ticket ticket = new Ticket();
      new Thread(ticket, "1号窗口").start();
      new Thread(ticket, "2号窗口").start();
      new Thread(ticket, "3号窗口").start();
   }
}
class Ticket implements Runnable {
   private int tick = 20;
   private Lock lock = new ReentrantLock();
   @Override
   public void run() {
      while (true) {
         lock.lock();
         try {
            if (tick > 0) {
               try {
                  Thread.sleep(200);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName() + " 完成售票，余票为 " + --tick);
            }
         } finally {
            lock.unlock();
         }
      }
   }
}
