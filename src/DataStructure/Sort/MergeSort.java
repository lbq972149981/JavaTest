package DataStructure.Sort;

import DataStructure.sortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class MergeSort {
   @Test
   public void test(){
      int[] arr = sortUtil.randArr(1,10,10);
      int[] arr1 = sortUtil.randArr(1,10,10);
      int[] arr2 = sortUtil.randArr(1,10,10);
      System.out.println("排序前："+ Arrays.toString(arr));
      mergeSort(arr);
      System.out.println("排序后："+Arrays.toString(arr));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr1));
      mergeSort(arr1);
      System.out.println("排序后："+Arrays.toString(arr1));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr2));
      mergeSort(arr2);
      System.out.println("排序后："+Arrays.toString(arr2));
   }
   /**
    * 优化
    */
   public static void mergeSort(int[] arr){
     mergeSort(arr,0,arr.length-1);
   }
   private static void mergeSort(int[] arr, int left, int right) {
      //(2)优化二，长度小于10，采用插入排序
      if(left+10>=right){
         InsertSort.insertSort(arr);//切换插入排序
         return;
      }
      int mid = (left+right)/2;
      mergeSort(arr,left,mid);//左边归并排序，使得左子序列有序
      mergeSort(arr,mid+1,right);//右边归并排序，使得右子序列有序
      if(arr[mid]<=arr[mid+1])return;//(1)优化一，有序则避免不必要归并
      merge(arr,left,mid,right);//将两个有序子数组合并操作
   }
   private static void merge(int[] arr, int left, int mid, int right) {
      int[] temp = new int[right-left];//(优化三，申请适宜内存空间)
      int i = left;//左序列指针
      int j = mid+1;//右序列指针
      int t = i;//临时数组指针
      while(i<=mid&&j<=right){
         if(arr[i]<=arr[j]){
            temp[t++] = arr[i++];
         }else {
            temp[t++] = arr[j++];
         }
      }
      while(i<=mid){//将左边剩余元素填充进temp中
         temp[t++] = arr[i++];
      }
      while(j<=right){//将右序列剩余元素填充进temp中
         temp[t++] = arr[j++];
      }
      while(left<=right){//将temp中的元素全部拷贝到原数组中
         arr[left] = temp[left];
         left++;
      }
   }
}
