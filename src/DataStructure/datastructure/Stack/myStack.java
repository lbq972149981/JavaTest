package DataStructure.datastructure.Stack;
/**
 * @author liubaoqing
 * @createTime 2018-08-07
 * @description
 */
public class myStack<E extends Comparable> {
   private Object[] element;
   private int size;
   private static final int default_capacity = 10;
   public boolean push(E element){
      return false;
   }
   public E pop(){
      return null;
   }
   public E peek(){
      return null;
   }
   public boolean isEmpty(){
      return false;
   }
   public void ensureCapacity(int size){

   }
   public int size(){
      return 0;
   }
}
