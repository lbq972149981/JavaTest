package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-07-17
 * @description
 */
public class StringT1 {
   public static void main(String[] args) {
      String str1 = "A";
      String str2 = str1;
      str1 += "B"+"C"; // -1-
      str2 = str2 + "B" + "C"; // -2-
   }
}
