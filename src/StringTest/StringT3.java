package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-08-02
 * @description
 */
public class StringT3 {
   public static void main(String[] args) {
      /**
      解答:
      上面所有equals()方法的结果都是true,因为equals()方法在String类中,我们来看下API中的解释
      equals:
      将此字符串与指定的对象比较。当且仅当该参数不为null，并且是与此对象表示相同字符序列的 String 对象时，结果才为true。
      因为String类中字符串是常量；它们的值在创建之后不能更改
      第一题中:
      //常量池中没有这个字符串对象,就创建一个,如果有直接用即可
      String s1 = "abc";
      String s2 = "abc";
      System.out.println(s1 == s2);         //==号比较的是地址值,true
      System.out.println(s1.equals(s2));    //比较的是字符串的内容:true
      第二题:
      //创建几个对象
      //创建两个对象,一个在常量池中,一个在堆内存中
      String s1 = new String("abc");
      System.out.println(s1);
      第三题:
      String s1 = new String("abc");        //录的是堆内存对象的地址值
      String s2 = "abc";                    //记录的是常量池中的地址值
      System.out.println(s1 == s2);         //false
      第四题:
      //byte b = 3 + 4;                     //在编译时就变成7,把7赋值给b,常量优化机制
      String s1 = "a" + "b" + "c";          //java中有常量优化机制,在编译时期就能确定s2的值为"abc",
                                              以编译时期,在常量池中创建"abc"
      String s2 = "abc";                    //执行到这里时常量池中已经有了"abc",所以就不再创建,
                                              所以s1和s2指向的是常量池中同一个字符串常量"abc"
      System.out.println(s1 == s2);         //true,java中有常量优化机制
      第五题:
      String s1 = "ab";
      String s2 = "abc";
      String s3 = s1 + "c";                 //s1是变量,s1与常量"c"相加
      System.out.println(s3 == s2);         //false
       */
   }
}
