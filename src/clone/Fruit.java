package clone;
import java.util.ArrayList;
import java.util.List;
public class Fruit implements Cloneable{
   private String name;
   private int price;
   public Fruit(String name, int price) {
      this.name = name;
      this.price = price;
   }
   public int getPrice() {
      return price;
   }
   public String getName() {
      return name;
   }
   @Override
   protected Fruit clone() throws CloneNotSupportedException {
      return (Fruit) super.clone();
   }
}
