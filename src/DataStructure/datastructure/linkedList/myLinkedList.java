package DataStructure.datastructure.linkedList;

/**
 * @author liubaoqing
 * @createTime 2018-08-07
 * @description
 */
public class myLinkedList<E extends Comparable> {
   public class Node{
      private E element;
      private Node next;
      public Node(E element, Node next) {
         this.element = element;
         this.next = next;
      }
   }
   private Node head;
   private int size;
   public boolean add(E element){
      return false;
   }
   public E remove(int index){
      return null;
   }
   public E get(int index){
      return null;
   }
}
