package DataStructure.Sort;

import DataStructure.sortUtil.sortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class HeapSort {
   @Test
   public void test(){
      int[] arr = sortUtil.randArr(1,10,10);
      int[] arr1 = sortUtil.randArr(1,10,10);
      int[] arr2 = sortUtil.randArr(1,10,10);
      System.out.println("排序前："+ Arrays.toString(arr));
      heapSort(arr);
      System.out.println("排序后："+Arrays.toString(arr));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr1));
      heapSort(arr1);
      System.out.println("排序后："+Arrays.toString(arr1));
      System.out.println("------------------进行优化-------------------");
      System.out.println("排序前："+Arrays.toString(arr2));
      heapSort(arr2);
      System.out.println("排序后："+Arrays.toString(arr2));
   }
   /**
    * 优化
    * (1)就地排序
    * (1)减少交换次数
    */
   public static void heapSort(int[] arr){
      buildMaxHeap(arr);
      /**交换堆顶和堆尾元素重新构造最大堆*/
      for(int i=arr.length-1;i>=0;i--){
         sortUtil.switchArr(arr,0,i);
         shiftDown(arr,0,i);
      }
   }
   /**构建大堆*/
   private static void buildMaxHeap(int[] arr){
      //从第一个非叶子节点开始，建堆
      for(int i=arr.length/2-1;i>=0;i--){
         shiftDown(arr,i,arr.length);
      }
   }
   /**下沉操作，传入数组以及需要排序的个数和下沉的索引*/
   private static void shiftDown(int[] arr,int i,int len){
      int temp = arr[i];//先取出当前元素
      for(int k=2*i+1;k<len;k=2*k+1){//从节点i的左子节点开始，也就是2i+1处开始
         if(k+1<len&&arr[k]<arr[k+1]){ //如果左子节点，小于右子节点，k指向右子节点
            k++;
         }
         if(arr[k]>temp){//如果子节点大于父节点，将子节点值赋给父节点，（不用进行交换）
            arr[i] = arr[k];
            i = k;
         }else {
            break;
         }
      }
      arr[i] = temp;
   }
}
