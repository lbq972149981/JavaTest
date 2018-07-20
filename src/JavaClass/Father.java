package JavaClass;

/**
 * @author liubaoqing
 * @createTime 2018-07-20
 * @description
 */
public class Father {
   String name;
   String age;
   public void speak(){
      System.out.println("speak Chinese");
   }
   public static void main(String[] args) {
      Father f = new child();
      f.speak();//speak English
   }
}
class child extends Father{
   @Override
   public void speak() {
      System.out.println("speak English");
   }
   public void play(){
      System.out.println("playing");
   }
}