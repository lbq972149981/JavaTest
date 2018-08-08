package reflectOrAnnotation;

/**
 * @author liubaoqing
 * @createTime 2018-08-02
 * @description
 */
public class OuterClass {
   public Runnable run = new Runnable(){
      @Override
      public void run() {
         System.out.println("running");
      }
   };
   class InnerClass{
      private String mName;
      public InnerClass(String name) {
         mName = name;
      }
      void getName() {
         System.out.println("name is:"+mName);
      }
   }
   static class StaticInnerClass{
      private String name;

      private StaticInnerClass(String name) {
         this.name = name;
      }

      private String getName() {
         System.out.println("getName");
         return name;
      }
   }
}
