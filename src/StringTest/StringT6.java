package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class StringT6 {
   public static void main(String[] args) {
      StringBuffer sb = new StringBuffer("Hello ");
      System.out.println("Before : sb = " + sb);
      changeData1(sb);
      System.out.println("After : sb = " + sb);
   }
   public static void changeData(StringBuffer strBuf) {
      strBuf.append("World!");
   }
   public static void changeData1(StringBuffer strBuf) {
      strBuf = new StringBuffer("hi ");
      strBuf.append("World!");
   }
}
