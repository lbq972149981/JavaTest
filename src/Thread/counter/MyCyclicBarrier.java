package Thread.counter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liubaoqing
 * @createTime 2018-07-24
 * @description
 */
public class MyCyclicBarrier {
   public static void main(String[] args) {
      CyclicBarrier callMasterBarrier = new CyclicBarrier(7, new Runnable() {
         @Override
         public void run() {
            System.out.println("7个法师已聚集，出发");
            Dargon();
         }
      });
      for(int i=1;i<=7;i++){
         int index = i;
         new Thread(()->{
            System.out.println("第"+index+"个法师已聚集");
            try {
               callMasterBarrier.await();
            } catch (InterruptedException |BrokenBarrierException e) {
               e.printStackTrace();
            }
         }).start();
      }
   }
   public static void Dargon(){
      CyclicBarrier callBallBarrier = new CyclicBarrier(7, new Runnable() {
         @Override
         public void run() {
            System.out.println("7个龙珠已找到，召唤");
         }
      });
      for(int i=1;i<=7;i++){
         int index = i;
         new Thread(()->{
            System.out.println("第"+index+"个龙珠已找到");
            try {
               callBallBarrier.await();
            } catch (InterruptedException |BrokenBarrierException e) {
               e.printStackTrace();
            }
         }).start();
      }
   }
}
