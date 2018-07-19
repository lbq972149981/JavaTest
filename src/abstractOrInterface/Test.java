package abstractOrInterface;

public class Test {
   public static void main(String[] args) {
      abstractTest child = new abstractChild();
      System.out.println(child.NameToUpper("asld9u"));
      System.out.println(child.getName());
      System.out.println(child.addName());
   }
}
