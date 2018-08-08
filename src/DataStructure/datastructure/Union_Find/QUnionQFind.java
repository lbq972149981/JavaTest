package DataStructure.datastructure.Union_Find;

/**
 * @author liubaoqing
 * @createTime 2018-08-07
 * @description
 */
/**基于谁的元素多，谁为新的根*/
public class QUnionQFind {
   private int[] parent;
   private int[] weight;
   private int size;
   public QUnionQFind(int size) {
      this.size = size;
      parent = new int[this.size];
      weight = new int[this.size];
      for(int i=0;i<parent.length;i++){
         parent[i] = i;
         weight[i] = 1;
      }
   }
   public int find(int element){//查找元素所在集合/组
      while(element != parent[element]){
         element = parent[element];
      }
      return element;
   }
   public boolean isConnected(int Aelement,int Belement){//判断两个元素是否在同一个集合/组
      return find(Aelement)==find(Belement);
   }
   public void unionElements(int Aelement,int Belement){//合并两个元素所在的集合
      int firstRoot = find(Aelement);
      int secondRoot = find(Belement);
      if(firstRoot==secondRoot)
         return;
      if (weight[firstRoot] > weight[secondRoot]) {
         parent[secondRoot] = firstRoot;
         weight[firstRoot] += weight[secondRoot];
      } else {//weight[firstRoot] <= weight[secondRoot]
         parent[firstRoot] = secondRoot;
         weight[secondRoot] += weight[firstRoot];
      }
   }
}
