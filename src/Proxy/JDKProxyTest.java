package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liubaoqing
 * @createTime 2018-07-31
 * @description
 */
public class JDKProxyTest {
   public static void main(String[] args) {
      System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
      final DogService dog = new DogServiceImpl();
      DogService dogProxy = null;
      dogProxy=(DogService) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(), dog.getClass().getInterfaces(),
            new InvocationHandler() {
         @Override
         public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("pre");
            //反射执行dog实例的method方法
            method.invoke(dog,args);//args 原方法形参列表
            System.out.println("next");
            return proxy;
         }
      });
      dogProxy.eat();
   }

}
