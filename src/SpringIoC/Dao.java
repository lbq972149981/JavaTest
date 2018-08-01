package SpringIoC;

/**
 * @author liubaoqing
 * @createTime 2018-07-30
 * @description
 */
public class Dao {
   private String school;
   public Dao(){

   }
   public void testA(){
      System.out.println("testA");
   }
   public user getUser(String name,int age){
      user u = new user();
      u.setName(name);
      u.setAge(age);
      return u;
   }

   public String getSchool() {
      return school;
   }

   public void setSchool(String school) {
      this.school = school;
   }
}
