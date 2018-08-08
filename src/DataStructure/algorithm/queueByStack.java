package DataStructure.algorithm;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class queueByStack {
   private Stack<Integer> sA;
   private Stack<Integer> sB;
   private int size;
   public queueByStack() {
      this.sA = new Stack<>();
      this.sB = new Stack<>();
      this.size = size = 0;
   }
   public void add(int elem){
      sA.push(elem);
      size++;
   }
   public int poll(){
      if(sB.isEmpty()) {
         while (!sA.isEmpty()) {
            sB.push(sA.pop());
         }
         if(sB.isEmpty())
            return -1;
      }
      size--;
      return sB.pop();
   }

   public static void main(String[] args) {
      queueByStack q = new queueByStack();
      q.add(1);
      q.add(2);
      q.add(3);
      q.add(4);
      q.add(5);
      System.out.println(q.poll());
      System.out.println(q.poll());
      System.out.println(q.poll());
      System.out.println(q.poll());
      System.out.println(q.poll());
      System.out.println(q.poll());
      System.out.println(q.poll());
      System.out.println(q.poll());
   }
}
