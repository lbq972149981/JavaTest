package Thread.createThreadMethod;

/**
 * @author liubaoqing
 * @createTime 2018-07-23
 * @description
 */
public class ByRunnable implements Runnable{
   @Override
   public void run() {
      System.out.println(Thread.currentThread().getName());
   }
   public static void main(String[] args) {
      Thread mythread = new Thread(new ByRunnable());
      mythread.setName("mySecondThread");
      mythread.start();
      System.out.println(Thread.currentThread());
   }
}
