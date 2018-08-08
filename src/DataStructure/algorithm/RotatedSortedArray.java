package DataStructure.algorithm;

import org.junit.Test;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class RotatedSortedArray {
   @Test
   public void test(){
      int[] arr = {5,6,7,8,9,10,1,2,3,4};
      int index = search(arr,6);
      System.out.println(index);
   }
   public static int search(int[] arr,int key){
      int left = 0;
      int right = arr.length-1;
      while(left<=right){
         int mid = (left+right)>>1;
         if(key==arr[mid])
            return mid;
         if(arr[left]<arr[mid]){
            if(arr[left]<=key && key<=arr[mid]){
               right = mid - 1;
            }else {
               left = mid + 1;
            }
         }else if(arr[left]>arr[mid]){
            if(arr[mid]<=key && key <= arr[right]){
               left = mid + 1;
            }else {
               right = mid - 1;
            }
         }else {
            left++;
         }
      }
      return -1;
   }
}
