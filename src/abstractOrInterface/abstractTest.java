package abstractOrInterface;

abstract class abstractTest implements interfaceTest{
   private String name;
   protected String NameToUpper(String name){
      return name.toUpperCase();
   }
   abstract String getName();
   abstract String addName();
   @Override
   public int getA() {
      return 0;
   }
}
