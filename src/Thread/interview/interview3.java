package Thread.interview;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liubaoqing
 * @createTime 2018-07-27
 * @description
 */
public class interview3 {
   private int maxSize = 10;
   private LinkedList<Object> list = new LinkedList<>();
   public void produce(String producer){
      synchronized (list){
         while(list.size()==maxSize){
            try {
               list.wait();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
         list.add(new Object());
         System.out.println("【"+producer+"】：生产了一个产品\t【现仓储量为】:" + list.size());
         list.notifyAll();
      }
   }
   public void consume(String consumer){
      synchronized (list){
         while(list.size()==0){
            try {
               list.wait();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
         list.remove();
         System.out.println("【"+consumer+"】：消费了一个产品\t【现仓储量为】:" + list.size());
         list.notifyAll();
      }
   }
   public static void main(String[] args) {
      interview3 inter = new interview3();
      for(int i=0;i<6;i++){
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