package SpringIoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liubaoqing
 * @createTime 2018-07-30
 * @description
 */
@Service
public class IoCTest {
   public IUserDao u1;
   //构造函数注入
   @Autowired
   public IoCTest(IUserDao u1) {
      this.u1 = u1;
   }
   public IUserDao u2;
   public IUserDao getU2() {
      return u2;
   }
   //属性注入
   @Autowired
   public void setU2(IUserDao u2) {
      this.u2 = u2;
   }
   public IUserDao u3;
   //方法注入
   @Autowired
   public void getU3(IUserDao u3,IUserDao u4){
      this.u3 = u3;
      System.out.println(u4);
   }
   //成员变量，属性注入
   @Resource
   public IUserDao u5;
   public static void main(String[] args) {
      ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
      IoCTest t = ac.getBean("IOCtest",IoCTest.class);
      System.out.println(t.u1);
      System.out.println(t.u2);
      System.out.println(t.u3);
      System.out.println(t.u5);
   }
}
