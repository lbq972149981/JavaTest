package DataStructure.algorithm;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author liubaoqing
 * @createTime 2018-08-06
 * @description
 */
public class 根号3 {
   @Test
   public void test(){
      for(int i=0;i<=10;i++){
         System.out.println(sqrt1((double)i,0.00001));
      }

      LinkedList list = new LinkedList();
     for(int i=1;i<=160;i++){
        list.add(i);
     }
      System.out.println(list);
     while(list.size()>1){
        for(int i=0;i<list.size();i++){
           list.remove(i);
        }
        System.out.println(list);
     }
      System.out.println(list.get(0));
   }
   //二分法
   public static double sqrt(double num,double precise){
      if(num<0)
         return -1;
      double low = 0;
      double high = num;
      double mid ,squre;
      while(high-low>precise){
         mid = (low+high)/2;
         squre = mid * mid;
         if(squre > num){
            high = mid;
         }else {
            low = mid;
         }
      }
      return (high+low)/2;
   }
   //牛顿迭代法
   //牛顿法的作用是使用迭代的方法来求解函数方程的根。简单地说，牛顿法就是不断求取切线的过程。
   //假设c为原数t为根数
   //t^2 = c
   //2t^2 = c + t^2
   //2t = c/t+t
   // t = (c/t+t)/2
   public static double sqrt1(double num,double precise){
      double t = num;
      while(Math.abs(t-num/t)>precise*t){
         t = (num/t+t)/2.0;
      }
      return t;
   }
}
