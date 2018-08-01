package Proxy;
/**
 * @author liubaoqing
 * @createTime 2018-07-31
 * @description
 */
public class DogServiceImpl implements DogService{
   @Override
   public void eat() {
      System.out.println("dog is eating");
   }
   @Override
   public void run() {
      System.out.println("dog is running");
   }
}
