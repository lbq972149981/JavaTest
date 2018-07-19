package reflectOrAnnotation;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author liubaoqing
 * @createTime 2018-07-17
 * @description
 */
public class ConfigReflect {
   public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
      Class cp = Class.forName(getPro("className"));
      Constructor<PersonR> constructor =  cp.getConstructor(String.class,Integer.class);
      Object obj = constructor.newInstance("李佳洋",18);
      Method method = cp.getDeclaredMethod(getPro("MethodName"),String.class);
      method.setAccessible(true);
      method.invoke(obj,"绵阳");
   }
   public static String getPro(String ProName) throws IOException {
      Properties properties = new Properties();
      FileReader fileReader = new FileReader("pro.Properties");
      properties.load(fileReader);
      fileReader.close();
      return properties.getProperty(ProName);
   }
}
