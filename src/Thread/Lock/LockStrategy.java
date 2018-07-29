package Thread.Lock;

/**
 * @author liubaoqing
 * @createTime 2018-07-24
 * @description 类锁：method1,method2。对象锁：method4, method5,method6.
 */
public class LockStrategy {
   public Object object1 = new Object();
   public static synchronized void method1(){}
   public void method2(){
      synchronized(LockStrategy.class){}
   }
   public synchronized void method4(){}
   public void method5()
   {
      synchronized(this){}
   }
   public void method6()
   {
      synchronized(object1){}
   }
}
