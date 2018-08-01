package SpringIoC;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @author liubaoqing
 * @createTime 2018-07-30
 * @description
 */
public class test {
   public static void main(String[] args) {
/*      ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
      BookService bs = ac.getBean("bookService",BookService.class);
      bs.storeBook("java");*/

      ApplicationContext ann =new AnnotationConfigApplicationContext(AppCfg.class);
      ICarDao dao = ann.getBean(ICarDao.class);
      People p = ann.getBean("getPeople",People.class);
      dao.add("dao");
      p.p();
   }
}
