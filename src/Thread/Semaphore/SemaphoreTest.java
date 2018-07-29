package Thread.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author liubaoqing
 * @createTime 2018-07-24
 * @description
 */
public class SemaphoreTest {
   public static void main(String[] args) {
      Semaphore semaphore = new Semaphore(5);
      for(int i=0;i<7;i++){
         new Thread(new EatThread(semaphore)).start();
      }
   }
}
class EatThread implements Runnable{
   private Semaphore semaphore;
   public EatThread(Semaphore semaphore){
      this.semaphore = semaphore;
   }
   @Override
   public void run() {
      try {
         semaphore.acquire();//获取一个许可，当然也可以调用acquire(int)，这样一个线程就能拿到多个许可
         long eatTime = (long)(Math.random()*10);
         System.out.println(Thread.currentThread().getId()+"正在吃饭");
         TimeUnit.SECONDS.sleep(eatTime);
         System.out.println(Thread.currentThread().getId()+"已经吃完!!!!!");
         semaphore.release();//归还许可
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
