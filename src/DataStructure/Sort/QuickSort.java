package DataStructure.Sort;

import DataStructure.sortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author liubaoqing
 * @createTime 2018-08-03
 * @description
 */
public class QuickSort {
   @Test
   public void test(){
      int[] arr = sortUtil.randArr(1,100,20);
      int[] arr1 = sortUtil.randArr(1,100,20);
      int[] arr2 = sortUtil.randArr(1,100,20);
      System.out.println("排序前："+ Arrays.toString(arr));
      quickSortNotR(arr,0,arr.length-1);
      System.out.println("排序后："+Arrays.toString(arr));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr1));
      quickSort(arr1);
      System.out.println("排序后："+Arrays.toString(arr1));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr2));
      quickSort(arr2);
      System.out.println("排序后："+Arrays.toString(arr2));
   }

   public static void quickSort(int[] arr){
//      quickSort(arr,0,arr.length-1,16);
        quickSortNotR(arr,0,arr.length-1);
   }
   private static void quickSort(int[] arr, int left, int right,int k) {
      //数组长度小，采用插入排序，效率高。
      if(right-left<=k){
         InsertSort.insertSort(arr);
         return;
      }
      if(left<right){
         int pos = partition2(arr,left,right);
         quickSort(arr,left,pos-1,k);
         quickSort(arr,pos+1,right,k);
      }
   }
   /**
    * 未优化
    * 思想：单路排序
    */
   public static int partition(int[] arr,int left,int right){
      int key = arr[left];
      int index = left;
      for(int i=left+1;i<=right;i++){
         if(key>arr[i]){
            index++;
            sortUtil.switchArr(arr,i,index);
         }
      }
      sortUtil.switchArr(arr,index,left);
      return index;
   }
   /**
    * 优化方案1(二路快排)
    * 思想：交换
    * @param arr
    */
   private static int partition1(int[] arr, int low, int high) {
      //排序前，先让基准值和随机的一个数进行交换。这样，基准值就有随机性。
      //就不至于在数组相对有序时，导致左右两边的递归规模不一致，产生最坏时间复杂度
      sortUtil.switchArr(arr,low,(int)(Math.random()*(high - low + 1)+low));
      int key = arr[low];
      while(low<high) {
         while (key <= arr[high] && low < high) {
            high--;
         }
         while (key >= arr[low] && low < high) {
            low++;
         }
         sortUtil.switchArr(arr,high,low);
      }
      sortUtil.switchArr(arr,low,high);
      return high;
   }

   /**
    * 优化方案2(二路快排)
    * 思想：直接赋值
    */
   private static int partition2(int[] arr, int low, int high) {
      //排序前，先让基准值和随机的一个数进行交换。这样，基准值就有随机性。
      //就不至于在数组相对有序时，导致左右两边的递归规模不一致，产生最坏时间复杂度
      sortUtil.switchArr(arr,low,(int)(Math.random()*(high - low + 1)+low));
      int key = arr[low];
      while(low<high) {
         while (key >= arr[low] && low < high)low++;
         arr[high] = arr[low];
         while (key <= arr[high] && low < high)high--;
         arr[low] = arr[high];
      }
      arr[high] = key;
      return high;
   }
   /**
    * 优化方案3(三路快排)
    * 大数据量，且重复数据多时，采用三路快排
    */
   private static int[] partition3(int[] arr, int low, int high) {
      //排序前，先让基准值和随机的一个数进行交换。这样，基准值就有随机性。
      //就不至于在数组相对有序时，导致左右两边的递归规模不一致，产生最坏时间复杂度
      sortUtil.switchArr(arr,low,(int)(Math.random()*(high - low + 1)+low));
      int key = arr[low];
      //三路快排分为下面这三个路(区间) low high cur
      int cur = low;
      while(cur<=high) {
        if(arr[cur]==key){
           cur++;
        }else if(arr[cur]<key){
           sortUtil.switchArr(arr,cur++,low++);
        }else {
           sortUtil.switchArr(arr,cur,high--);
        }
      }
      return new int[]{low-1,high+1};
   }
   //三数取中
   private static int GetMid(int[] array,int left,int right)
   {
      int mid = left + ((right - left)>>1);
      if(array[left] <= array[right])
      {
         if(array[mid] <  array[left])
            return left;
         else if(array[mid] > array[right])
            return right;
         else
            return mid;
      }
      else
      {
         if(array[mid] < array[right])
            return right;
         else if(array[mid] > array[left])
            return left;
         else
            return mid;
      }
   }
   public static void quickSortNotR(int[] arr,int low,int high){
      System.out.println(1111);
      Stack<Integer> stack = new Stack<>();
      stack.push(high);
      stack.push(low);
      while(!stack.isEmpty()){
         int left = stack.pop();
         int right = stack.pop();
         int index = partition(arr,left,right);
         if((index-1)>left){
            stack.push(index-1);
            stack.push(left);
         }
         if((index+1)<right){
            stack.push(right);
            stack.push(index+1);
         }
      }
   }
}
