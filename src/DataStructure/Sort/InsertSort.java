package DataStructure.Sort;

import DataStructure.sortUtil.sortUtil;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-03
 * @description
 */
public class InsertSort {
   public static void main(String[] args) {
      int[] arr = sortUtil.randArr(1,10,10);
      int[] arr1 = sortUtil.randArr(1,10,10);
      int[] arr2 = sortUtil.randArr(1,10,10);
      int[] arr3 = sortUtil.randArr(1,10,10);
      System.out.println("排序前："+ Arrays.toString(arr));
      insertSort(arr);
      System.out.println("排序后："+Arrays.toString(arr));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr1));
      insertSort1(arr1);
      System.out.println("排序后："+Arrays.toString(arr1));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr2));
      insertSort2(arr2);
      System.out.println("排序后："+Arrays.toString(arr2));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr3));
      insertSort3(arr3);
      System.out.println("排序后："+Arrays.toString(arr3));
   }

   /**
    * 未改进
    * 思想：将第index个数与前面已经排好的数列比较，插入到相应位置
    */
   public static void insertSort(int[] arr) {
      for(int i=1;i<arr.length;i++){
         for(int j=i;j>0&&arr[j]<arr[j-1];j--){
            sortUtil.switchArr(arr,j,j-1);
         }
      }
   }

   /**
    * 优化方案1()
    * 思想：主要优化了内层循环，可以提前结束，且不使用swap方法
    */
   public static void insertSort1(int[] arr) {
      for(int i=1;i<arr.length;i++){
         int temp = arr[i];
         int j;
         for(j=i;j>0&&temp<arr[j-1];j--){
            arr[j] = arr[j-1];
         }
         arr[j] = temp;
      }
   }

   /**
    * 二分插入排序
    * 思想：利用二分查找迅速找到插入位置，减少元素比较次数提高效率。
    */
   public static void insertSort2(int[] arr) {
      int high,low,mid;
      int temp;
      for(int i=1;i<arr.length;i++){
         low = 0;
         high = i-1;
         temp = arr[i];
         while(low<=high){
            mid = (low+high)>>1;
            //如果待插入记录比中间记录小
            if(temp<arr[mid]){
               high = mid - 1;
            }else {
               low = mid + 1;
            }
         }
         for(int j=i-1;j>=low;j--){
            arr[j+1] = arr[j];
         }
         arr[low] = temp;
      }
   }

   /**
    * 二路-插入排序
    *
    */
   public static void insertSort3(int[] arr) {
      int[] newArr = new int[arr.length];
      newArr[0] = arr[0];//将原数组的第一个元素作为枢纽元素
      int first = 0;     //指向最小元素的指针
      int last = 0;      //指向最大元素的指针
      for(int i=1;i<arr.length;i++){
         //大于等于最大元素，直接插入到last后面，不用移动元素
         if(arr[i]>=newArr[last]){
            last++;
            newArr[last] = arr[i];
         }
         //小于最小元素，直接插到first前面，不用移动元素
         else if(arr[i]<newArr[first]){
            first = (first-1+arr.length)%arr.length;
            newArr[first] = arr[i];
         }
         //在最大值与最小值之间，且大于等于枢纽元素，插入到last之前，需要移动元素
         else if(arr[i]>=newArr[0]){
            int currIndex = last;
            last++;
            do{
               //比array[i]大的元素后移一位
               newArr[currIndex+1] = newArr[currIndex];
               currIndex--;
            }while (newArr[currIndex]>arr[i]);
            newArr[currIndex+1] = arr[i];
         }else {
            int currIndex = first;
            first = (first-1+arr.length)%arr.length;
            do{
               newArr[currIndex-1] = newArr[currIndex];
               currIndex = (currIndex+1+arr.length)%arr.length;
            }while (newArr[currIndex]<=arr[i]);
            newArr[(currIndex-1+arr.length)%arr.length] = arr[i];
         }
      }
      arr = newArr;
      System.out.println(Arrays.toString(newArr));
   }
}
