package Thread.BlockingQueue;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author liubaoqing
 * @createTime 2018-07-25
 * @description
 */
public class MyBlockingQueue1 {
   private LinkedList<Object> list = new LinkedList<>();
   private int limit = 10;
   private AtomicInteger count = new AtomicInteger(0);
   public MyBlockingQueue1(int limit){
      this.limit = limit;
   }
   public synchronized void put(Object obj){
      //注意要使用while循环，而不是if，因为下面的notifyAll可能把正在等待的入队线程给唤醒
      while(this.list.size()==limit){
         try {
            wait();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      if(this.list.size()==0){
         notifyAll();
      }
      this.list.add(obj);
      System.out.println("新添加的元素为："+obj);
      count.incrementAndGet();
   }
   public synchronized Object take(){
      while(this.list.size()==0){
         try {
            wait();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      if(this.list.size()==this.limit){
         notifyAll();
      }
      count.decrementAndGet();
      return this.list.remove(0);
   }
   public int getSize(){
      return this.count.get();
   }
   public static void main(String[] args) {
      MyBlockingQueue1 blockingQueue = new MyBlockingQueue1(5);
      blockingQueue.put("a");
      blockingQueue.put("b");
      blockingQueue.put("c");
      blockingQueue.put("d");
      blockingQueue.put("e");
      System.out.println(blockingQueue.getSize());
      new Thread(new Runnable() {
         @Override
         public void run() {
            //此时容器已经满了,会阻塞
            blockingQueue.put("f");
            blockingQueue.put("g");
         }
      }).start();
      new Thread(new Runnable() {
         @Override
         public void run() {
            //从容器里面拿元素，同时唤醒添加元素的线程
            Object o1= blockingQueue.take();
            System.out.println("当前移除的元素"+o1);
            Object o2= blockingQueue.take();
            System.out.println("当前移除的元素"+o2);
         }
      }).start();
   }
}
