package DataStructure.Sort;

import DataStructure.sortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class BucketSort {
   @Test
   public void test(){
      int[] arr = sortUtil.randArr(1,10,10);
      int[] arr1 = sortUtil.randArr(1,10,10);
      int[] arr2 = sortUtil.randArr(1,10,10);
      System.out.println("排序前："+ Arrays.toString(arr));
      bucketSort(arr);
      System.out.println("排序后："+Arrays.toString(arr));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr1));
      bucketSort(arr1);
      System.out.println("排序后："+Arrays.toString(arr1));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr2));
      bucketSort(arr2);
      System.out.println("排序后："+Arrays.toString(arr2));
   }

   /**
    * 未优化
    */
   public static void bucketSort(int[] arr){
      int[] temp = new int[arr.length];
      int[] bucket = new int[arr.length];//声明桶的数量
      //排序操作,即放到桶里面
      for(int i=0;i<arr.length;i++){
         bucket[arr[i]]++;
      }
      int index = 0;
      for(int i=0;i<bucket.length;i++){
         if(bucket[i]!=0){
            //元素中的值为几，就说明有多少个相同值的元素，就输出几遍
            for(int j=0;j<bucket[i];j++){
               temp[index++] = i;
            }
         }
      }
      for(int i=0;i<arr.length;i++){
         arr[i] = temp[i];
      }
   }
}
