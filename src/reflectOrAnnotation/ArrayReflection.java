package reflectOrAnnotation;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author liubaoqing
 * @createTime 2018-07-19
 * @description
 */
public class ArrayReflection {
   public static void main(String[] args) {
      int[] arr = {1,2,3,4,5,6,7};
      int[] newArr = (int[])arrayInc(arr,10);
      print(newArr);
   }
   public static Object arrayInc(Object arr,int len){
      Class carr = arr.getClass().getComponentType();
      Object newArr = Array.newInstance(carr,len);
      int l = Array.getLength(arr);
      System.arraycopy(arr,0, newArr,0,l);
      return newArr;
   }
   public static void print(Object arr){
      Class carr = arr.getClass();
      if(!carr.isArray())return;
      for(int i=0;i<Array.getLength(arr);i++){
         if((int)Array.get(arr,i)==0){
            Array.set(arr,i,-1);
         }
         System.out.print(Array.get(arr,i)+" ");
      }
   }
}
