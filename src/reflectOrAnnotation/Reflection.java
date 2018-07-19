package reflectOrAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liubaoqing
 * @createTime 2018-07-17
 * @description Java反射机制
 */
public class Reflection {
   public static void main(String[] args) throws Exception {
      /*获取字节码(Class)对象的三种方式*/
      PersonR per = new PersonR();
      Class cp1 = per.getClass();//方法一
      Class cp2 = PersonR.class;//方法二
      Class cp3 = Class.forName("reflectOrAnnotation.PersonR");//方法三
      /*获取构造器--getConstructor()*/
      Class cp = per.getClass();
      Constructor<PersonR> constructor = cp.getConstructor();
      Constructor<PersonR> constructor1 = cp.getConstructor(String.class,Integer.class);
      PersonR p1 = constructor.newInstance();//p1.setName() null;
      PersonR p2 = constructor1.newInstance("lijiayang",19);//p1.setName() lijiayang;
      /*获取Class中的属性--getField()*/
      Field field_address = cp.getField("address");//获取公有属性address
      Field field_name = cp.getDeclaredField("name");//获取私有属性name
      field_name.setAccessible(true); //对私有字段的访问取消检查
      PersonR p3 = (PersonR)cp.newInstance();//创建无参对象实例
      field_name.set(p3,"李佳洋");
      Object obj_name = field_name.get(p3);//obj_name -> 李佳洋
      /*获取Class中的方法--*/
      Method PerInfor = cp.getDeclaredMethod("PerInfor",null);
      Method PerInfor_adress = cp.getDeclaredMethod("PerInfor",String.class);
      Method countAge = cp.getDeclaredMethod("countAge", int.class);
      PerInfor.setAccessible(true);
      PerInfor_adress.setAccessible(true);
      PersonR p4 = constructor1.newInstance("lijiayang",19);//p1.setName() lijiayang;
      PerInfor_adress.invoke(p4,"四川");//lijiayang:19:四川
      PerInfor.invoke(p4);//lijiayang:19
      countAge.invoke(p4,15);//34-->15+19
      /*获取Child父类中的私有方法*/
      Class child = Child.class;
      Class cPerson = child.getSuperclass();
      Field cP_name = cPerson.getDeclaredField("name");
      cP_name.setAccessible(true);
      Object pp = cPerson.getConstructor(String.class,Integer.class).newInstance("lijiayang",19);
      cP_name.set(pp,"李佳洋");//李佳洋

   }
}
