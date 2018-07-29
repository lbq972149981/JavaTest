package Collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author liubaoqing
 * @createTime 2018-07-20
 * @description
 */
public class UpdateArrayList {
   public static void main(String[] args) {
      ArrayList<Integer> arrayList = new ArrayList<>();
      arrayList.add(1);
      arrayList.add(2);
      arrayList.add(3);
      arrayList.add(4);
      arrayList.add(5);
      System.out.println(arrayList);
//      for(Integer v : arrayList){
//         System.out.println(v);
//         if(v==3){
//            arrayList.remove(v);
//         }
//      }
      Iterator it = arrayList.iterator();
      while(it.hasNext()){
         Integer v = (int)it.next();
         System.out.println(v);
         if(v==2){
            it.remove();
         }
      }
      System.out.println(arrayList);
   }
}
