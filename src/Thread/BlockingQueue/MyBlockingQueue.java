package Thread.BlockingQueue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liubaoqing
 * @createTime 2018-07-25
 * @description
 */
public class MyBlockingQueue {
   private LinkedList<Object> list = new LinkedList<>();
   //需要一个计数器，统计加入List集合元素的个数
   private AtomicInteger count = new AtomicInteger(0);
   //需要指定上限和下限
   private int maxSize ;
   private int minSize = 0;
   //创建queue时指定最大长度
   public MyBlockingQueue(int maxSize){
      this.maxSize = maxSize;
   }
   //初始化一个对象，用于加锁
   private Object lock = new Object();
   public void put(Object obj){
      synchronized (lock){
         //注意要使用while循环，而不是if，因为下面的notifyAll可能把正在等待的入队线程给唤醒
         while(count.get()==this.maxSize){
            try {
               lock.wait();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
         list.add(obj);
         count.incrementAndGet();
         System.out.println("新添加的元素为："+obj);
         //唤醒其他线程
         lock.notify();
      }
   }
   public Object take(){
      Object temp =null;
      synchronized (lock){
         while(count.get()==this.minSize){
            try {
               lock.wait();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
         temp = list.removeFirst();
         count.decrementAndGet();
         //唤醒其他线程
         lock.notify();
      }
      return temp;
   }
   public int getSize(){
      return this.count.get();
   }
   public static void main(String[] args) {
      MyBlockingQueue blockingQueue = new MyBlockingQueue(5);
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
