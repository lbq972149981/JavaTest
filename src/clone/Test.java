package clone;
//如果要实现 clone 要先实现 Cloneable 接口，然后重写 clone() 方法
public class Test {
   public static void main(String[] args) throws CloneNotSupportedException {
      //浅拷贝
      System.out.println("浅拷贝");
      Fruit fruit1 = new Fruit("apple",18);
      Fruit fruit2 = fruit1.clone();
      System.out.println(fruit1==fruit2);//false
      System.out.println(fruit1.getName()==fruit2.getName());//true
      //深拷贝
      System.out.println("深拷贝");
      Person person1 = new Person(new Body(new Head()));
      Person person2 = person1.clone();
      System.out.println(person1==person2);//false
      System.out.println(person1.getBody()==person2.getBody());//false
      System.out.println(person1.getBody().getHead()==person2.getBody().getHead());//false
   }
}
