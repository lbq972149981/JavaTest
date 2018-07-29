package Thread;

/**
 * @author liubaoqing
 * @createTime 2018-07-24
 * @description
 */
public class volatileTest {
   private static int a;
   private static int b;
   private static int c;
   private volatileTest(){

   }
   private volatile static volatileTest vol;
   public static volatileTest getInstance(){
      if(vol==null)
      synchronized (volatileTest.class){
         if(vol==null){
            a = 1;//1
            b = 2;//2
            vol = new volatileTest();//3
            c = a + b;//4

         }
      }
      return vol;
   }
}
