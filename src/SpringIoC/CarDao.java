package SpringIoC;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liubaoqing
 * @createTime 2018-07-30
 * @description
 */
@Repository
public class CarDao implements ICarDao{
   @Override
   public void add(String name) {
      System.out.println("添加"+name+"成功");
   }
}
