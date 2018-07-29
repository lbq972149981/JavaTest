package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-07-27
 * @description
 */
public class Stringreverse {
   public static void main(String[] args) {
      System.out.println(reverse("ABCD"));
      System.out.println("ABCD".substring(1));
   }
   public static String reverse(String originStr){
      if(originStr==null||originStr.length()<=1)
         return originStr;
      return reverse(originStr.substring(1))+originStr.charAt(0);
   }
}
