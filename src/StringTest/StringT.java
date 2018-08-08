package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-07-17
 * @description
 */
public class StringT {
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
      System.out.println(s1==s2);//true
      System.out.println(s1==s4);//true
      System.out.println(s1==s5);//false
      /**在String类中，intern方法是一个本地方法，在JAVA SE6之前，
       * intern方法会在运行时常量池中查找是否存在内容相同的字符串，
       * 如果存在则返回指向该字符串的引用，如果不存在，则会将该字符串入池，
       * 并返回一个指向该字符串的引用。*/
      System.out.println(s1==s6);//true
      /**这里面虽然将b用final修饰了，但是由于其赋值是通过方法调用返回的，
       * 那么它的值只能在运行期间确定，因此a和c指向的不是*/
      System.out.println(s1==s8);//false
      System.out.println(s1==s10);//false
   }
   public static String getHello() {
      return "hello";
   }
}
