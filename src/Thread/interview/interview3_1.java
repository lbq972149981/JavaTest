package Thread.interview;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liubaoqing
 * @createTime 2018-07-27
 * @description
 */
public class interview3_1 {
   private int maxSize = 10;
   private LinkedList<Object> list = new LinkedList<>();
   private final Lock lock = new ReentrantLock();
   private final Condition fullCon = lock.newCondition();
   private final Condition emptyCon = lock.newCondition();
   public void produce(String producer){
      lock.lock();
      try {
         while(list.size()==maxSize){
            try {
               fullCon.await();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
         list.add(new Object());
         System.out.println("【" + producer + "】：生产了一个产品\t【现仓储量为】:"+list.size());
         emptyCon.signalAll();
      }finally {
         lock.unlock();
      }
   }
   public void consume(String consumer){
      lock.lock();
      try {
         while(list.size()==0){
            try {
               emptyCon.await();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
         list.remove();
         System.out.println("【" + consumer + "】：消费了一个产品\t【现仓储量为】:"+list.size());
         fullCon.signalAll();
      }finally {
         lock.unlock();
      }
   }
   public static void main(String[] args) {
      interview3_1 inter = new interview3_1();
      for(;;){
         new Thread(new Runnable() {
            @Override
            public void run() {
               int rand = (int)(Math.random()*10);
               for(int i=0;i<rand;i++) {
                  inter.produce("生产者");
               }
            }
         }).start();
         new Thread(new Runnable() {
            @Override
            public void run() {
               int rand = (int)(Math.random()*10);
               for(int i=0;i<rand;i++) {
                  inter.consume("消费者");
               }
            }
         }).start();
      }
   }
}
