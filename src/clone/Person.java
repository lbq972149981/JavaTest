package clone;
public class Person implements Cloneable{
   private Body body;
   public Person(Body body) {
      this.body = body;
   }
   public Body getBody() {
      return body;
   }
   @Override
   protected Person clone() throws CloneNotSupportedException {
      Person person = (Person)super.clone();
      person.body = body.clone();
      return person;
   }
}
class Body implements Cloneable{
   private Head head;
   public Body(Head head) {
      this.head = head;
   }
   public Head getHead() {
      return head;
   }
   @Override
   protected Body clone() throws CloneNotSupportedException {
      Body body = (Body)super.clone();
      body.head = head.clone();
      return body;
   }
}
class Head implements Cloneable{
   @Override
   protected Head clone() throws CloneNotSupportedException {

      return (Head)super.clone();
   }
}
