package 智力题;

import org.junit.Test;

/**
 * @author liubaoqing
 * @createTime 2018-08-03
 * @description 58人围圈 3的倍数离开
 */
public class 围圈_2 {
   class Node{
      private Node next;
      private int value;
      public Node(int value) {
         this.value = value;
      }
   }

   private Node head ;
   /**约瑟夫环*/
   @Test
   public void test() {
      Node first = new Node(1);
      Node last = first;
      for(int i=2;i<=54;i++){
         last.next = new Node(i);
         last = last.next;
      }
      last.next = first;
      while(last!=last.next){
         for(int i=1;i<3;i++){
            last = last.next;
         }
         System.out.println("出圈："+last.next.value);
         last.next = last.next.next;
      }
      System.out.println("幸存者:"+last.value);
   }
   /**
    * 2.围圈_2
    * 3倍数
    * 9倍数
    */
   public static void main(String[] args) {

   }
}
