package reflectOrAnnotation;

public class PersonR {
   private String name;
   private Integer age;
   public String address;
   public PersonR(){
   }
   public PersonR(String name, Integer age) {
      this.name = name;
      this.age = age;
   }
   private String PerInfor(){
      System.out.println(this.name+":"+this.age);
      return this.name+":"+this.age;
   }
   private String PerInfor(String address){
      System.out.println(this.name+":"+this.age+":"+address);
      return this.name+":"+this.age+":"+address;
   }
   @AgeValidator(max = 30,min = 20)
   public int countAge(Integer age){
      System.out.println(age);
      return age;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getAge() {
      return age;
   }
   public void setAge(Integer age) {
      this.age = age;
   }
}
