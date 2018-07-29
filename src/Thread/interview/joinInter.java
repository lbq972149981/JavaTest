package Thread.interview;

/**
 * @author liubaoqing
 * @createTime 2018-07-27
 * @description 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 */
public class joinInter {
   public static void main(String[] args) {
      Thread t1 = new Thread(new Runnable() {
         @Override
         public void run() {
            System.out.println("t1执行完毕");
         }
      });
      Thread t2 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               t1.join();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("t2执行完毕");
         }
      });
      Thread t3 = new Thread(new Runnable() {
         @Override
         public void run() {
            try {
               t2.join();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            System.out.println("t3执行完毕");
         }
      });
      t3.start();
      t2.start();
      t1.start();

   }
}
