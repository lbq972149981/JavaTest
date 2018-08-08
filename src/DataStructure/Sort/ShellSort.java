package DataStructure.Sort;

import DataStructure.sortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-03
 * @description
 */
public class ShellSort {
   @Test
   public void test(){
      int[] arr = sortUtil.randArr(1,10,10);
      int[] arr1 = sortUtil.randArr(1,10,10);
      int[] arr2 = sortUtil.randArr(1,10,10);
      System.out.println("排序前："+ Arrays.toString(arr));
      shellSort(arr);
      System.out.println("排序后："+Arrays.toString(arr));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr1));
      shellSort1(arr1);
      System.out.println("排序后："+Arrays.toString(arr1));
   }

   /**
    * 未优化
    * 思想：先取定一个小于n的整数d1作为第一个增量，把表的全部记录分成d1个组，
    * 所有距离为d1的倍数的记录放在同一个组中，在各组内进行直接插入排序；
    */
   public static void shellSort(int[] arr){
      int len = arr.length/2;
      do{
         for(int i = len;i<arr.length;i++){
            for(int j=i;j>0&&j>=len&&arr[j]<arr[j-len];j-=len){
               sortUtil.switchArr(arr,j,j-len);
            }
         }
         len = len/2;
      }while(len>0);
   }

   /**
    * 优化方案1()
    * 思想：主要优化了内层循环，可以提前结束，且不使用swap方法
    */
   public static void shellSort1(int[] arr){
      int len = arr.length/2;
      while(len>0){
         for(int i = len;i<arr.length;i++){
            int temp = arr[i];
            int j;
            for(j=i;j>0&&j>=len&&temp<arr[j-len];j-=len){
               arr[j] = arr[j-len];
            }
            arr[j] = temp;
         }
         len = len/2;
      }
   }
}
