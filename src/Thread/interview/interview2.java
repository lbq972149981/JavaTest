package Thread.interview;

/**
 * @author liubaoqing
 * @createTime 2018-07-27
 * @description 设计四个线程,其中两个线程每次对变量i加1,另外两个线程每次对i减1.
 */
public class interview2 {
   private int i =0;
   public synchronized void addOne(){
      i++;
      System.out.println(Thread.currentThread().getId()+"addOne:"+i);
   }
   public synchronized void subOne(){
      i--;
      System.out.println(Thread.currentThread().getId()+"subOne:"+i);
   }
   class addThread implements Runnable{
      @Override
      public void run() {
         for(int i=0;i<10;i++){
            addOne();
         }
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   class subThread implements Runnable{
      @Override
      public void run() {
         for(int i=0;i<10;i++){
            subOne();
         }
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
   public static void main(String[] args) {
      interview2 inter = new interview2();
      subThread sub = inter.new subThread();
      addThread add = inter.new addThread();
      for(int i=0;i<2;i++){
          new Thread(sub).start();
          new Thread(add).start();
      }
   }
}
