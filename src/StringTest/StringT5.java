package StringTest;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class StringT5 {
   public static void main(String[] args) {
      int num = 10;
      System.out.println("pre:"+num);
      count(num);
      System.out.println("next:"+num);
      student s1 = new student();
      student s2 = new student();
      s1.setAge(0);
      s2.setAge(100);
      System.out.println("s1:"+s1.getAge()+"----s2:"+s2.getAge());
      swap(s1,s2);
      System.out.println("s1:"+s1.getAge()+"----s2:"+s2.getAge());
   }
   public static void count(int x){
      x = 2*x;
   }
   public static void swap(student s1,student s2){

      student temp = s1;
      s1 = s2;
      s2 = temp;
   }
}
class student{
   private int age;

   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
}