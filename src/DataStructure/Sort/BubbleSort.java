package DataStructure.Sort;

import DataStructure.sortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-03
 * @description
 */
public class BubbleSort {
   @Test
   public void test(){
      int[] arr = sortUtil.randArr(1,10,10);
      int[] arr1 = sortUtil.randArr(1,10,10);
      int[] arr2 = sortUtil.randArr(1,10,10);
      System.out.println("排序前："+Arrays.toString(arr));
      bubbleSort(arr);
      System.out.println("排序后："+Arrays.toString(arr));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr1));
      bubbleSort1(arr1);
      System.out.println("排序后："+Arrays.toString(arr1));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr2));
      bubbleSort2(arr2);
      System.out.println("排序后："+Arrays.toString(arr2));
   }

   /**
    * 未优化
    */
   public static void bubbleSort(int[] arr){
     for(int i=0;i<arr.length;i++){
        for(int j=1;j<arr.length-i;j++){
           if(arr[j]<arr[j-1]){
              sortUtil.switchArr(arr,j-1,j);
           }
        }
     }
   }
   /**
    优化方案1(原数组有序)
    优化思路：
    假如在第1轮比较当中，发现所有的元素都没有进行交换，则说明此原数据就是有序的，不需要再进行排序。
    */
   public static void bubbleSort1(int[] arr){
      boolean flag = false;
      for(int i=0;i<arr.length;i++){
         flag = true;
         for(int j=1;j<arr.length-i;j++){
            if(arr[j]<arr[j-1]){
               sortUtil.switchArr(arr,j,j-1);
               flag = false;
            }
         }
         if(flag){
            break;
         }
      }
   }
   /**
    优化方案2(下标index以后有序)
    优化思路：
    优化，记录最后一次交换的下标index，下一次只需比较到index即可。
    */
   public static void bubbleSort2(int[] arr){
      boolean flag = true;
      int index = 0;
      int k = arr.length;
      for(int i=0;i<arr.length&&flag;i++){
         flag = false;
         index = 0;
         for(int j=1;j<k;j++){
            if(arr[j]<arr[j-1]){
               sortUtil.switchArr(arr,j,j-1);
               flag = true;
               index = j;
            }
         }
         k = index;
      }
   }
}
