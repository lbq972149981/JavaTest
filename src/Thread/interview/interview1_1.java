package Thread.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author liubaoqing
 * @createTime 2018-07-27
 * @description
 */
public class interview1_1 {
   private boolean flag = false;
   private Lock lock = new ReentrantLock();
   private Condition con  = lock.newCondition();
   public void sub() {
      lock.lock();
      try {
         while (flag) {
            try {
               con.await();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
         for (int i = 0; i < 10; i++) {
            System.out.println("sub" + i);
         }
         flag = true;
         con.signal();
      }finally {
         lock.unlock();
      }
   }
   public void main(){
      lock.lock();
      try {
      while (!flag) {
         try {
            con.await();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      for (int i = 0; i < 20; i++) {
         System.out.println("Main" + i);
      }
      flag = false;
      con.signal();
      }finally {
         lock.unlock();
      }
   }
   public static void main(String[] args) {
      interview1_1 inter = new interview1_1();
      new Thread(new Runnable() {
         @Override
         public void run() {
            for(int i=0;i<50;i++){
               inter.sub();
            }
         }
      }).start();
      for(int i=0;i<50;i++){
         inter.main();
      }
   }
}
