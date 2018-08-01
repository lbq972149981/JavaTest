package SpringIoC;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liubaoqing
 * @createTime 2018-07-30
 * @description
 */

public class user {
   private String name;
   private int age;
   private String address;
   private Dao dao;
   private List<Dao> daoList;
   @Override
   public String toString() {
      return "user{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", address='" + address + '\'' +
            ", dao=" + dao +
            ", daoList=" + daoList +
            '}';
   }
   public user() {
   }
   public user(String name, int age) {
      this.name = name;
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public Dao getDao() {
      return dao;
   }

   public void setDao(Dao dao) {
      this.dao = dao;
   }

   public List<Dao> getDaoList() {
      return daoList;
   }

   public void setDaoList(List<Dao> daoList) {
      this.daoList = daoList;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
   public void init(){
      System.out.println(this.getName()+" is created");
   }
   public void destory(){
      System.out.println(this.getName()+" is distory");
   }
}
