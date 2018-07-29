package Integer;

/**
 * @author liubaoqing
 * @createTime 2018-07-20
 * @description
 */
public class IntegerTest {
   public static void main(String[] args) {
      Integer v = 100;//自动装箱，把基本类型转成对象
      int m = v + 100;//自动拆箱，把对象转成基本类型
      Integer m1 = 127;
      Integer m2 = 127;
      Integer m3 = 128;
      Integer m4 = 128;
      Integer m5 = new Integer(127);
      Integer m6 = new Integer(128);
      System.out.println(m1==127);//true
      System.out.println(m3==128);//true
      System.out.println(m1==m2);//true
      System.out.println(m1==m5);//false
      System.out.println(m3==m4);//false
      System.out.println(m3==m6);//false
   }
}
