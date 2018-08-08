package DataStructure.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liubaoqing
 * @createTime 2018-08-05
 * @description
 */
public class ArrToMap {
   private int[] map;           //存储key-value键值对
   private List<Integer> keySet;//存储key
   private List<Integer> values;//存储value
   private int size;            //map的大小
   private int capacity;        //基本容量
   private int index;           //下标
   private int capacitySize;    //map数组容量，阈值
   public ArrToMap() {
      this.capacity = 10;
      this.map = new int[this.capacity];
      this.index = 0;
      this.capacitySize = 0;
      this.keySet = new ArrayList<>();
      this.values = new ArrayList<>();
   }
   /**添加键值对*/
   public void put(int key,int value){
      if(capacitySize>=map.length){
         this.map = Arrays.copyOf(map,map.length*2);
      }
      if(isExist(key)){
         map[2*search(key)+1]=value;
         return;
      }
      map[index++] = key;
      map[index++] = value;
      keySet.add(key);
      values.add(value);
      size++;
      capacitySize += 2;
   }
   /**获取key->value*/
   public int get(int key){
      return map[search(key)*2+1];
   }
   /**返回map大小*/
   public int getSize() {
      return size;
   }
   /**查找key的下标*/
   private int search(int key){
      return keySet.indexOf(key);
   }
   /**判断key值是否存在*/
   private boolean isExist(int key){
      return keySet.contains(key);
   }
   public static void main(String[] args) {
      ArrToMap a = new ArrToMap();
      a.put(1,100);
      a.put(2,101);
      a.put(3,102);
      a.put(4,103);
      a.put(5,104);
      a.put(6,104);
      System.out.println(Arrays.toString(a.map));
      System.out.println(a.keySet);
      System.out.println(a.get(1));
      System.out.println(a.get(2));
      System.out.println(a.get(3));
      System.out.println(a.get(4));
      System.out.println(a.get(5));
      System.out.println(a.get(6));
      System.out.println(a.getSize());
   }
}
