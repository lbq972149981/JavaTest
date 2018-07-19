package reflectOrAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author liubaoqing
 * @createTime 2018-07-17
 * @description
 */
public class testAnnotation {
   public static void main(String[] args) throws Exception {
      Class cp = PersonR.class;
      Object obj = cp.newInstance();
      Method countAge = cp.getDeclaredMethod("countAge", Integer.class);
      countAge.setAccessible(true);
      Annotation annotation = countAge.getAnnotation(AgeValidator.class);
      int val1 = 45;
      if(annotation!=null){
         if(annotation instanceof AgeValidator){
            AgeValidator ageValidator = (AgeValidator) annotation;
            if (val1< ageValidator.min() || val1>ageValidator.max()){
               throw new RuntimeException("数值超出范围");
            }
         }
      }
      countAge.invoke(obj,val1);//Exception in thread "main" java.lang.RuntimeException: 数值超出范围
   }
}
