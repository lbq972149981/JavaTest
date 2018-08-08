package DataStructure.datastructure.Union_Find;

/**
 * @author liubaoqing
 * @createTime 2018-08-07
 * @description
 */
public class UnionFind {
   private int[] id;//内容为集合，下标为元素
   private int size;
   public UnionFind(int size) {
      this.size = size;
      id = new int[this.size];
      for(int i=0;i<id.length;i++){
         id[i] = i;
      }
   }
   public int find(int element){//查找元素所在集合/组
      return id[element];
   }
   public boolean isConnected(int Aelement,int Belement){//判断两个元素是否在同一个集合/组
      return find(Aelement)==find(Belement);
   }
   public void unionElements(int Aelement,int Belement){//合并两个元素所在的集合
      int firstUnion = find(Aelement);
      int secondUnion = find(Belement);
      if(firstUnion==secondUnion)
         return;
      for(int i=0;i<this.size;i++){
         if(id[i]==firstUnion){
            id[i] = secondUnion;
         }
      }
   }
}
