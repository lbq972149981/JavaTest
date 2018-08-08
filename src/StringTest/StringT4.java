package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-08-02
 * @description
 */
public class StringT4 {
   public static void main(String[] args) {
      String s = "heima";
      System.out.println(s);
      change(s);
      System.out.println(s);System.out.println("---------------------");
      StringBuffer sb = new StringBuffer();
      sb.append("heima");
      System.out.println(sb);
      change(sb);
      System.out.println(sb);
   }
   public static void change(StringBuffer sb) {
      //调用该方法时实际参数的sb和形式参数的sb指向的是同一个对象(StringBuffer容器)
      //方法内部又在该容器里添加了"itcast",所以方法结束时,局部变量的sb消失,
      // 但是实际参数的sb所指向的容器的内部的内容已经发生了改变
      sb.append("itcast");
   }
   public static void change(String s) {
      s += "itcast";
   }
   public static void changeString(String str) {
      //因为str是属于局部变量,在调用该方法是实际参数s和形式参数str指向同一个字符串对象
      //但是在方法内部将str又指向了一个新的字符串对象,而此时s还是指向的原来的字符串对象
      //changeString方法执行完毕,局部变量str消失,方法内部产生的新的字符串对象称为垃圾
      //但是s还是指向的原有的字符串对象,并没有改变
      str += "itcast";
   }
}
