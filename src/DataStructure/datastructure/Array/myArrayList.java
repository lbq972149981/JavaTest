package DataStructure.datastructure.Array;

/**
 * @author liubaoqing
 * @createTime 2018-08-07
 * @description
 */
public class myArrayList<E extends Comparable> {
   private Object[] element;
   private static final int default_capacity = 10;
   private int size;
   public myArrayList(){

   }
   public myArrayList(int size) {
      this.size = size;
   }
   public boolean add(E element){
      return false;
   }
   public E get(int index){
      return null;
   }
   public boolean isEmpty(){
      return false;
   }
   public boolean set(E oldElement,E newElement){
      return false;
   }
   public void ensureCapacity(int size){

   }
   public E remove(int index){
      return null;
   }
   public int size(){
      return 0;
   }
}
