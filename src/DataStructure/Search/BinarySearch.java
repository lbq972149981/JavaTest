package DataStructure.Search;

import org.junit.Test;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class BinarySearch {
   @Test
   public void test(){
      int[] arr = {1,1,2,3,4,5,7,9};
      int index = binarySearch(arr,2);
      System.out.println(index);
      index = binarySearch2(arr,2);
      System.out.println(index);
   }
   public static int binarySearch(int[] arr,int key){
      int low = 0;
      int high = arr.length-1;
      int mid;
      while(low<=high){
         mid = (low+high)/2;
         if(arr[mid] == key){
            return mid;
         }
         if(key < arr[mid]){
            high = mid-1;
         }
         if(key > arr[mid]){
            low = mid+1;
         }
      }
      return -1;
   }
   public static int binarySearch2(int[] arr,int key){
      int low = 0;
      int high = arr.length-1;
      return binarySearch2(arr,key,low,high);
   }
   public static int binarySearch2(int[] arr,int key,int low,int high){
      int mid = low + (high-low)/2;
      if(arr[mid] == key)
         return mid;
      if(key < arr[mid])
         return binarySearch2(arr,key,low,mid-1);
      if(key > arr[mid])
         return binarySearch2(arr,key,mid+1,high);
      return -1;
   }
}
