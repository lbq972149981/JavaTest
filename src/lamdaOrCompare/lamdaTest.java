package lamdaOrCompare;

import clone.Fruit;

import java.util.*;

public class lamdaTest {
   public static void main(String[] args) {
      List<Integer> arr = Arrays.asList(4,5,7,1,2,6,4,14,2,1,7);
      List<Fruit> fruitList = new ArrayList<>();
      fruitList.add(new Fruit("apple",17));
      fruitList.add(new Fruit("apple",12));
      fruitList.add(new Fruit("apple",21));
      fruitList.add(new Fruit("banana",45));
      fruitList.add(new Fruit("orange",26));
      Collections.sort(fruitList, new Comparator<Fruit>() {
         @Override
         public int compare(Fruit o1, Fruit o2) {
            if(!o1.getName().equals(o2.getName()))
               return o1.getName().compareTo(o2.getName());
            else
               return o1.getPrice()-o2.getPrice();
         }
      });
      Collections.sort(arr,(a,b)->{return b-a;});
      System.out.println(arr);
      fruitList.forEach(fruit->{
         System.out.println(fruit.getName()+"---"+fruit.getPrice());
      });
//      Sqrt s = (num)->{return Math.sqrt(num);};
      Sqrt s = Math::sqrt;
      double res = s.sqrt(16);
      System.out.println(res);//3.0
   }
}
