package Thread.Lock;

/**
 * @author liubaoqing
 * @createTime 2018-07-24
 * @description
 */
public class DieLockTest {
   public static String A = "A";
   public static String B = "B";
   public static void main(String[] args) {
      new DieLockTest().deadLock();
   }
   private void deadLock(){
      Thread threadA = new Thread(new Runnable() {
         @Override
         public void run() {
            synchronized (A){
               try {
                  Thread.currentThread().sleep(2000);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               synchronized (B){
                  System.out.println("AB");
               }
            }
         }
      });
      Thread threadB = new Thread(new Runnable() {
         @Override
         public void run() {
            synchronized (B){
               try {
                  Thread.currentThread().sleep(2000);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               synchronized (A){
                  System.out.println("BA");
               }
            }
         }
      });
      threadA.start();
      threadB.start();
   }
}
