package 智力题;

/**
 * @author liubaoqing
 * @createTime 2018-08-03
 * @description 从1开始，每次操作+1或*2 最少多少步，达到2014  (18)
 */
public class 获得整数2014_1 {
   /**
    * 1.2014
    * 答案 18
    * 2014/2 -- 1007
    * 1007-1 -- 1006
    * 1006/2 -- 503
    * .......
    *
    * 二进制 :11111011110
    * 左移，减1
    */
   public static void main(String[] args) {
      int num = 2014;
      int count = 0;
      while(num!=1){
         num = num>>1;
         num -= 1;
         count += 2;
      }
      System.out.println(count);
   }
}
