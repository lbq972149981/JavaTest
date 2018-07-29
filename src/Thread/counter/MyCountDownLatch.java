package Thread.counter;

import java.util.concurrent.CountDownLatch;

/**
 * @author liubaoqing
 * @createTime 2018-07-24
 * @description
 */
public class MyCountDownLatch {
   private static CountDownLatch counter = new CountDownLatch(7);
   public static void main(String[] args) throws InterruptedException {
      for(int i=1;i<=7;i++){
         int index = i;
         new Thread(){
            @Override
            public void run() {
               System.out.println("第"+index+"颗龙珠找到");
               try {
                  Thread.currentThread().sleep(2000);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               counter.countDown();
            }
         }.start();
      }
      counter.await();
      System.out.println("可以召唤神龙了");
   }
}
