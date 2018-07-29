package Thread.interview;

/**
 * @author liubaoqing
 * @createTime 2018-07-27
 * @description
 */
public class joinInter1 implements Runnable{
   @Override
   public void run() {
      System.out.println(Thread.currentThread().getName()+"执行完");
   }
   public static void main(String[] args) throws InterruptedException {
      Thread t1 = new Thread(new joinInter1(),"t1");
      Thread t2 = new Thread(new joinInter1(),"t2");
      Thread t3 = new Thread(new joinInter1(),"t3");
      t1.start();
      t1.join();
      t2.start();
      t2.join();
      t3.start();
      t3.join();
   }
}
