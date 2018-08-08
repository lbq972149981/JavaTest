package DataStructure.Search;

import org.junit.Test;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description 差值查找
 */
public class InterpolationSearch {
   @Test
   public void test(){
      int[] arr = {1,1,2,3,4,5,7,9};
      int index = interpolationSearch(arr,2);
      System.out.println(index);
      index = interpolationSearch(arr,2);
      System.out.println(index);
   }
   public static int interpolationSearch(int[] arr,int key){
      return interpolationSearch(arr,key,0,arr.length-1);
   }
   public static int interpolationSearch(int[] arr,int key,int low,int high){
      int mid = low + ((key-arr[low])/(arr[high]-arr[low]))*(high-low);
      if(arr[mid] == key)
         return mid;
      if(key < arr[mid])
         return interpolationSearch(arr,key,low,mid-1);
      if(key > arr[mid])
         return interpolationSearch(arr,key,mid+1,high);
      return -1;
   }
}
