package localCache;

/**
 * @author liubaoqing
 * @createTime 2018-07-26
 * @description
 */
public class Test {
   public static void main(String[] args) {
      LocalCache lcCache = new LocalCache();
      lcCache.putValue("1001", "zs", 30000);
      lcCache.putValue("1002", "ls", 30000);
      lcCache.putValue("1003", "ww", 30000);
      lcCache.putValue("1004", "zq", 30000);
      String strValue = (String)lcCache.getValue("1002");
      System.out.println(strValue);

   }
}
