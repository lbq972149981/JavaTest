package DataStructure.Sort;

import DataStructure.sortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-03
 * @description
 */
public class SelectSort {
   @Test
   public void test(){
      int[] arr = sortUtil.randArr(1,10,10);
      int[] arr1 = sortUtil.randArr(1,10,10);
      int[] arr2 = sortUtil.randArr(1,10,10);
      System.out.println("排序前："+ Arrays.toString(arr));
      SelectSort(arr);
      System.out.println("排序后："+Arrays.toString(arr));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr1));
      SelectSort1(arr1);
      System.out.println("排序后："+Arrays.toString(arr1));
   }
   /**
    * 未优化
    * 思想：设置第一个为初始最大元素,遍历,将倒数第i+1个元素与max交换
    */
   public static void SelectSort(int[] arr){
      for(int i=0;i<arr.length;i++){
         int max = arr[0];
         int index = 0;
         int j;
         for(j=0;j<arr.length-i;j++){
            if(max < arr[j]){
               max = arr[j];
               index = j;
            }
         }
         sortUtil.switchArr(arr,index,j-1);
      }
   }
   /**
    * 优化方案1
    * 思想：如果在每一次查找最小值的时候，也可以找到一个最大值
    * 然后将两者分别放在它们应该出现的位置，这样遍历的次数就比较少了
    */
   public static void SelectSort1(int[] arr){
      int left = 0;
      int right = arr.length-1;
      int minIndex = left;
      int maxIndex = left;
      while(left<=right){
         minIndex = left;
         maxIndex = left;
         for(int i=left;i<=right;i++){
            if(arr[i]<arr[minIndex]){
                minIndex = i;
            }
            if(arr[i]>arr[maxIndex]){
               maxIndex = i;
            }
         }
         sortUtil.switchArr(arr,left,minIndex);
         if(left == maxIndex)
            maxIndex = minIndex;
         sortUtil.switchArr(arr,right,maxIndex);
         left++;right--;
      }
   }
}
