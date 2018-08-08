package DataStructure.Search;

import org.junit.Test;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class SequenceSearch {
   @Test
   public void test(){
      int[] arr = {1,7,2,15,9,24,13,8,12,2,6,29};
      int index = sequenceSearch(arr,1);
      System.out.println(index);
      index = sequenceSearch1(arr,1);
      System.out.println(index);
   }
   public static int sequenceSearch(int[] arr,int key){
      for(int i=0;i<arr.length;i++){
         if(arr[i]==key)
            return i;
      }
      return -1;
   }
   /**
    * 优化
    * 设置哨兵，无需if判断
    */
   public static int sequenceSearch1(int[] arr,int key){
      arr[0] = key;
      int i = arr.length-1;
      while(arr[i]!=key){
         i--;
      }
      return i;
   }
}
