package reflectOrAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author liubaoqing
 * @createTime 2018-08-02
 * @description
 */
public class InnerTest {
   public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {
      Class outerClass = OuterClass.class;
      /**
       * 获取内部类 静态内部类
       * 第一种
       * Class staticinnerClass1 = Class.forName("reflectOrAnnotation.OuterClass$StaticInnerClass");
       * Class innerClass1 = Class.forName("reflectOrAnnotation.OuterClass$InnerClass");
       */
      /**
       * 获取内部类 静态内部类
       * 第二种
       */
      Class[] innerClasses = outerClass.getDeclaredClasses();
      for(Class innerClass:innerClasses){
         int mod = innerClass.getModifiers();
         String modifier = Modifier.toString(mod);
         if(modifier.contains("static")){
           Method getNameMethod =  innerClass.getDeclaredMethod("getName");
           getNameMethod.setAccessible(true);
           Constructor constru =  innerClass.getDeclaredConstructor(String.class);
           constru.setAccessible(true);
           OuterClass.StaticInnerClass staticInner =
                 (OuterClass.StaticInnerClass) constru.newInstance("李佳洋");
           String res = (String)getNameMethod.invoke(staticInner);
           System.out.println("name is:"+res);
         }else {
            Method getNameMethod =  innerClass.getDeclaredMethod("getName");
            Constructor constru =  innerClass.getDeclaredConstructors()[0];
            //特别注意!!!!内部类newInstance的第一个参数必须是外部类实例的引用
            OuterClass.InnerClass inner =
                  (OuterClass.InnerClass) constru.newInstance(outerClass.newInstance(),"lijiayang");
            getNameMethod.invoke(inner);
         }
      }
      /**
       * 获取匿名内部类
       */
      Runnable run = (Runnable) outerClass.getField("run").get(outerClass.newInstance());
      run.run();

   }
}
