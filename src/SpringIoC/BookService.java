package SpringIoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author liubaoqing
 * @createTime 2018-07-30
 * @description
 */
@Service
public class BookService {
   @Autowired
   public bookDao bookDao;
   public void storeBook(String bookname){
      System.out.println("图书上货");
      String result=bookDao.addBook(bookname);
      System.out.println(result);
   }
}
