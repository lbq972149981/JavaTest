package DataStructure.datastructure.Union_Find;

/**
 * @author liubaoqing
 * @createTime 2018-08-07
 * @description
 */
/**基于谁的高度高，谁为新的根*/
public class QUnionQFind1 {
   /**内容为集合，下标为元素*/
   private int[] parent;
   private int[] height;
   private int size;

   public QUnionQFind1(int size) {
      this.size = size;
      parent = new int[this.size];
      height = new int[this.size];
      for(int i=0;i<parent.length;i++){
         parent[i] = i;
         height[i] = 1;
      }
   }
   /**查找元素所在集合/组*/
   public int find(int element){
      while(element != parent[element]){
         //路径压缩->当前节点指向自己父亲的父亲，减少深度
         parent[element] = parent[parent[element]];
         element = parent[element];
      }
      return element;
   }
   /**判断两个元素是否在同一个集合/组*/
   public boolean isConnected(int Aelement,int Belement){
      return find(Aelement)==find(Belement);
   }
   /**合并两个元素所在的集合*/
   public void unionElements(int Aelement,int Belement){
      int firstRoot = find(Aelement);
      int secondRoot = find(Belement);

      if (height[firstRoot] < height[secondRoot]) {
         parent[firstRoot] = secondRoot;
      } else if (height[firstRoot] > height[secondRoot]) {
         parent[secondRoot] = firstRoot;
      } else {
         parent[firstRoot] = secondRoot;
         height[secondRoot] += 1;
      }
   }
}
