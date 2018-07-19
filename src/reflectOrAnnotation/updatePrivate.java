package reflectOrAnnotation;

import java.lang.reflect.Field;

public class updatePrivate {
   public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
      //PersonR类 两个私有变量name 和 age
      //使用set get
      PersonR personR = new PersonR();
      personR.setName("liu");
      System.out.println(personR+":"+personR.getName()+"==="+personR.getAge());
      //使用java 反射机制
      Class perc = PersonR.class;
      Field name = perc.getDeclaredField("name");//获取name属性
      Field age = perc.getDeclaredField("age");
      name.setAccessible(true);//设置可见性
      age.setAccessible(true);
      name.set(personR,"lijiayang");//设置personR对象的name属性值为lijiayang
      age.set(personR,18);//设置personR对象的age属性值为18
      System.out.println(personR+":"+personR.getName()+"==="+personR.getAge());

   }
}
