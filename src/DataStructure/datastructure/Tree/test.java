package DataStructure.datastructure.Tree;

/**
 * @author liubaoqing
 * @createTime 2018-08-08
 * @description
 */
public class test {
   public static void main(String[] args) {
      BinarySearchTree<Integer,String> bs = new BinarySearchTree<Integer,String>();
      bs.insert(5,"A");
      bs.insert(7,"B");
      bs.insert(3,"C");
      bs.insert(1,"D");
      bs.insert(9,"E");
      bs.insert(6,"F");
      bs.insert(4,"G");
//      bs.remove(1);
      bs.inOrder();
      System.out.println(bs.size());
      System.out.println(bs.contains("B"));
      System.out.println(bs.contains("D"));
      System.out.println(bs.contains("G"));
      System.out.println(bs.contains("AAA"));
      System.out.println(bs.findMax());
      System.out.println(bs.findMin());
      System.out.println(bs.search(6));
      System.out.println(bs.search(4));
      System.out.println(bs.search(1));
      bs.leveltraversal();
   }
}
