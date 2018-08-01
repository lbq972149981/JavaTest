package SpringIoC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liubaoqing
 * @createTime 2018-07-30
 * @description
 */
@Configuration
@ComponentScan(basePackages = "SpringIoC")
public class AppCfg {
   @Bean
   public People getPeople(){
      return new People();
   }
   @Bean
   public ICarDao getICarDao(){
      return new CarDao();
   }
}
