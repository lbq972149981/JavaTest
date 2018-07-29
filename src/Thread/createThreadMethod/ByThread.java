package Thread.createThreadMethod;

/**
 * @author liubaoqing
 * @createTime 2018-07-23
 * @description
 */
public class ByThread extends Thread{
   @Override
   public void run() {
      System.out.println(Thread.currentThread().getName());
   }
   public static void main(String[] args) {
      ByThread mythread = new ByThread();
      mythread.setName("MyFirstthread");
      mythread.start();
      System.out.println(Thread.currentThread());
   }
}
