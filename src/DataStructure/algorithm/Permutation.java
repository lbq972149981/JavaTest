package DataStructure.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-06
 * @description
 */
public class Permutation {
   @Test
   public void test(){
      String[] str = {"a","b","c"};
      permutation(str,0,2);
   }
   public static void permutation(String[] str,int first,int end){
      if(first == end){
         System.out.println(Arrays.toString(str));
      }
      for(int i=first;i<=end;i++){
         swap(str,i,first);
         permutation(str,first+1,end);
         swap(str,i,first);
      }
   }
   private static void swap(String[] str, int a, int b) {
      String temp = str[a];
      str[a] = str[b];
      str[b] = temp;
   }
}
