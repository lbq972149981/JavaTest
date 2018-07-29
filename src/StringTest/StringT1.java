package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-07-17
 * @description
 */
public class StringT1 {
   public static void main(String[] args) {
      final String str1 = "A";
      String str2 = str1;
      String str3 = "AB";
      String str5 = new String("AB");
      String str4 = str2.intern() + "B";
      System.out.println(str5.intern()==str3);
      /*long start = System.currentTimeMillis();
      for(int i =0;i<100000;i++){
         str1 += "B" + "C";
      }
      long end = System.currentTimeMillis();

      long start1 = System.currentTimeMillis();
      for(int i =0;i<100000;i++){
         str2 = str2 + "B" + "C";
      }
      long end1 = System.currentTimeMillis();
      System.out.println(end-start);
      System.out.println(end1-start1);*/
   }
}
