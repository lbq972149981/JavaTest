package reflectOrAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author liubaoqing
 * @createTime 2018-07-17
 * @description
 */
public class 泛型 {
   public static void main(String[] args) throws Exception {
      ArrayList<String> strList = new ArrayList<>();
      strList.add("aaa");
      strList.add("bbb");
      Class listClass = strList.getClass();
      Method add_method = listClass.getMethod("add", Object.class);
      add_method.invoke(strList,100);
      System.out.println(strList);//[aaa, bbb, 100]
   }
}
