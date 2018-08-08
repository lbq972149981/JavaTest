package DataStructure.Search;

import org.junit.Test;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class HashSearch {
   @Test
   public void test(){
      int[] arr = {1,1,2,3,4,5,7,9};
      int index = hashSearch(arr,2);
      System.out.println(index);
      index = hashSearch(arr,2);
      System.out.println(index);
   }
   public static int hashSearch(int[] arr,int key){
      int hashtable[] = new int[7];
      hashtable = insert(hashtable,arr);
      int hashAdress = hash(hashtable,key);
      while(hashtable[hashAdress]!=key){
         hashAdress = (++hashAdress)%hashtable.length;
         //查找到了开放单元或者循环回到原点，表示查找失败
         if(hashtable[hashAdress]==0||hashAdress == hash(hashtable,key));
      }
      return hashAdress;
   }
   private static int[] insert(int[] hashtable, int[] arr) {
      for(int i=0;i<arr.length;i++){
         int hashAdress = hash(hashtable,arr[i]);
         while(hashAdress!=0){//不为0，发生冲突
            //开放地址法的线性探测解决冲突
            hashAdress = (++hashAdress)%hashtable.length;
         }
         hashtable[hashAdress] = arr[i];
      }
      return hashtable;
   }
   //hash函数，除留余数法
   private static int hash(int[] hashtable,int value){
      return value%hashtable.length;
   }

}
