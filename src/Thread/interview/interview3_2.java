package Thread.interview;

import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liubaoqing
 * @createTime 2018-07-27
 * @description
 */
public class interview3_2 {
   private int maxSize = 10;
   private BlockingDeque<Object> list = new LinkedBlockingDeque<>(maxSize);
   public void produce(String producer){
      synchronized (list) {
         if (list.size() == maxSize) {
            System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
         } else {
            try {
               list.put(new Object());
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("【" + producer + "】：生产了一个产品\t【现仓储量为】:"+list.size());
         }
      }
   }
   public void consume(String consumer){
      synchronized (list) {
         if (list.size() == 0) {
            System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
         } else {
            try {
               list.take();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("【" + consumer + "】：消费了一个产品\t【现仓储量为】:"+list.size());
         }
      }
   }
   public static void main(String[] args) {
      interview3_2 inter = new interview3_2();
      for(int i=0;i<4;i++){
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
