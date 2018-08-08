package DataStructure.Search;

import org.junit.Test;
import sun.security.provider.MD2;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class FibonacciSearch {
   @Test
   public void test(){
      int[] arr = {1,1,2,3,4,5,7,9};
      int index = FibonacciSearch(arr,2);
      System.out.println(index);
      index = FibonacciSearch(arr,2);
      System.out.println(index);
   }
   public static int FibonacciSearch(int[] arr,int key){
      return FibonacciSearch(arr,key,0,arr.length-1);
   }
   private static int FibonacciSearch(int[] arr, int key, int low, int high) {
      int[] f = new int[arr.length];
      f[0] = 1;
      f[1] = 1;
      for(int i=2;i<f.length;i++)
         f[i] = f[i-1] + f[i-2];
      int k = 0;
      while(arr.length>f[k]-1)k++;//找出数组的长度在斐波数列（减1）中的位置，将决定如何拆分
      int[] temp = Arrays.copyOf(arr, f[k] - 1);// 构造一个长度为fb[k]-1的新数列
      for(int i= arr.length;i<temp.length;i++){
         if(i >= arr.length)
            temp[i] = arr[arr.length-1];
      }
      while (low <= high) {
         int middle = low + f[k - 1] - 1;
         if (temp[middle] > key) {
            high = middle - 1;
            k = k - 1;
         } else if (temp[middle] < key) {
            low = middle + 1;
            k = k - 2;
         } else {
            if (middle <= high) {
               return middle;// 若相等则说明mid即为查找到的位置
            } else {
               return high;// middle的值已经大于hight,进入扩展数组的填充部分,即最后一个数就是要查找的数。
            }
         }
      }
      return -1;
   }
}
