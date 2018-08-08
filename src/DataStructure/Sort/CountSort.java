package DataStructure.Sort;

import DataStructure.sortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class CountSort {
   @Test
   public void test(){
      int[] arr = sortUtil.randArr(1,10,10);
      int[] arr1 = sortUtil.randArr(1,10,10);
      int[] arr2 = sortUtil.randArr(1,10,10);
      System.out.println("排序前："+ Arrays.toString(arr));
      countSort(arr);
      System.out.println("排序后："+Arrays.toString(arr));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr1));
      countSort(arr1);
      System.out.println("排序后："+Arrays.toString(arr1));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr2));
      countSort(arr2);
      System.out.println("排序后："+Arrays.toString(arr2));
   }

   /**
    * 优化
    * 减少countArr的内存空间，如数字区间在1000100-1000200
    */
   public static void countSort(int[] arr){
      int[] temp = new int[arr.length];
      //计算区间及最小值到最大值
      int max = arr[0];
      int min = arr[0];
      for(int i=0;i<arr.length;i++){
         if(arr[i]>=max)max = arr[i];
         if(arr[i]<=min)min = arr[i];
      }
      //计算相应位置数字个数
      int[] countArr = new int[max-min+1];//优化一，减少countArr的内存空间
      for(int i=0;i<arr.length;i++)
         countArr[arr[i]-min]++;
      //计算前面元素个数
      for(int i=1;i<countArr.length;i++)
         countArr[i] = countArr[i] + countArr[i-1];
      //把arr[i]的值赋给前面元素个数的位置
      for(int i=0;i<temp.length;i++)
         temp[--countArr[arr[i]-min]] = arr[i];

      for(int i=0;i<arr.length;i++)
         arr[i] = temp[i];
   }
}
