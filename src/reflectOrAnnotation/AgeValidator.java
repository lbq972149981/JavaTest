package reflectOrAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liubaoqing
 * @createTime 2018-07-17
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)//运行时检验
@Target(value = {ElementType.METHOD})//作用在方法上
public @interface AgeValidator {
   int max();
   int min();
}
