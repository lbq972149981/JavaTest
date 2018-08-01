package Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liubaoqing
 * @createTime 2018-07-31
 * @description
 */
public class CGlibProxyTest {
   public static void main(String[] args) {
      DogServiceImpl dog = new DogServiceImpl();
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(dog.getClass());
      enhancer.setCallback(new MethodInterceptor() {
         @Override
         public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("pre");
            methodProxy.invoke(dog,args);
            System.out.println("next");
            return proxy;
         }
      });
      DogServiceImpl dogProxy = (DogServiceImpl)enhancer.create();
      dogProxy.eat();
   }
}
