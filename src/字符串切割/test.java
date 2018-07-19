package 字符串切割;

import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
   public static void main(String[] args) {
      String str = "abc|12|3yy98|0";
      String[] strs = str.split("\\|");
      int maxSplitNum = 2;
      String[] strs1 = str.split("\\|",maxSplitNum);
      System.out.println(Arrays.deepToString(strs));
      System.out.println(Arrays.deepToString(strs1));

      StringTokenizer st = new StringTokenizer(str,"\\|");
      while(st.hasMoreElements()){
         System.out.print(st.nextElement()+" ");
      }


   }
}
