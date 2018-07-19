package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-07-17
 * @description
 */
public class StringT2 {
   public static void main(String[] args) {
      String s1 = "hello2";
      String s2 = "hello"+2;
      final String s3 = "hello";
      String s4 = s3 + 2;
      String s5 = new String("hello2");
      String s6 = s5.intern();
      final String s7 = getHello();
      String s8 = s7+2;
      String s9 = "hello";
      String s10 = s9+2;
      System.out.println(s1==s2);
      System.out.println(s1==s4);
      System.out.println(s1==s5);
      System.out.println(s1==s6);
      System.out.println(s1==s8);
      System.out.println(s1==s9);
   }
   public static String getHello() {
      return "hello";
   }
}

