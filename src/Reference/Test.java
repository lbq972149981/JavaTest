package Reference;

import java.lang.ref.SoftReference;

/**
 * @author liubaoqing
 * @createTime 2018-07-23
 * @description
 */
public class Test {
   public static void main(String[] args) {
      Browser per = new Browser();
      SoftReference sr = new SoftReference(per);
      if(sr.get()!=null){
         per = (Browser)sr.get();
      }else {
         per = new Browser();
         sr = new SoftReference(per);
      }
   }
}
