package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-07-20
 * @description
 */
public class StringToInt {
   public static void main(String[] args) {
      String str = "123";
      Integer integer = new Integer(str);
      int num1 = Integer.valueOf(str); //返回值 Integer
      int num2 = Integer.parseInt(str);//返回值 int
      int num3 = integer.intValue();   //返回值 int
   }
}
