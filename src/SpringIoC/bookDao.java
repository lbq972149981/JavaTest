package SpringIoC;

import org.springframework.stereotype.Component;

/**
 * @author liubaoqing
 * @createTime 2018-07-30
 * @description
 */
@Component("bookdao")
public class bookDao implements IbookDao{

   @Override
   public String addBook(String bookname) {
      return "添加图书"+bookname+"成功！";
   }
}
