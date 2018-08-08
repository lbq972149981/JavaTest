package DataStructure.datastructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liubaoqing
 * @createTime 2018-08-07
 * @description
 */
public class BinarySearchTree<K extends Comparable,V extends Comparable> {
   public class Node{
      private K key;
      private V value;
      private Node leftChild;
      private Node rightChild;
      public Node(K key,V value, Node leftChild, Node rightChild) {
         this.key = key;
         this.value = value;
         this.leftChild = leftChild;
         this.rightChild = rightChild;
      }
   }
   public BinarySearchTree(){
      this.root = null;
   }
   private Node root;
   private int size;
   //中序遍历
   public void inOrder(){
      inOrder(root);
      System.out.println();
   }
   private void inOrder(Node root) {
      if(root==null)
         return;
      inOrder(root.leftChild);
      System.out.print(root.key+"-"+root.value+" ");
      inOrder(root.rightChild);
   }
   //先序遍历
   public void preOrder(){
      preOrder(root);
      System.out.println();
   }
   private void preOrder(Node root) {
      if(root == null)
         return;
      System.out.print(root.key+"-"+root.value+" ");
      preOrder(root.leftChild);
      preOrder(root.rightChild);
   }
   //后序遍历
   public void postOrder(){
      postOrder(root);
      System.out.println();
   }
   private void postOrder(Node root) {
      if(root == null)
         return;
      postOrder(root.leftChild);
      postOrder(root.rightChild);
      System.out.print(root.key+"-"+root.value+" ");
   }
   //层次遍历
   public void leveltraversal(){
      leveltraversal(root);
   }
   private void leveltraversal(Node root) {
      if(root==null)
         return;
      LinkedList<Node> queue = new LinkedList<Node>();
      queue.add(root);
      while(!queue.isEmpty()){
         Node node = queue.remove();
         System.out.print(node.key+"-"+node.value+" ");
         if(node.leftChild!=null)
            queue.add(node.leftChild);
         if(node.rightChild!=null)
            queue.add(node.rightChild);
      }
   }

   //查找key 对应的value
   public V search(K key){
      return search(key,root);
   }
   private V search(K key, Node root) {
      if(root == null)
         return null;
      if(root.key.compareTo(key)==0){
         return root.value;
      }else if(root.key.compareTo(key)>0){
         return search(key,root.leftChild);
      }else {
         return search(key,root.rightChild);
      }
   }
   //是否包含value
   public boolean contains(V value){
      return contains(value,root);
   }
   private boolean contains(V value, Node root) {
      boolean flag = false;
      if(root == null)
         return false;
      if(root.value.compareTo(value)==0) {
         flag = true;
         return flag;
      }
      if(root.leftChild!=null&&!flag)
         flag =  contains(value,root.leftChild);
      if(root.rightChild!=null&&!flag)
         flag =  contains(value,root.rightChild);
      return flag;
   }
   //返回节点个数
   public int size(){
      return this.size;
   }
   //找到最大元素
   public K findMax(){
      if(root == null)
         return null;
      return findMax(root);
   }
   private K findMax(Node root) {
      if(root.rightChild != null)
         return findMax(root.rightChild);
      return root.key;
   }
   //找到最小元素
   public K findMin(){
      if(root==null)
         return null;
      return findMin(root);
   }
   private K findMin(Node root) {
      if(root.leftChild!=null)
         return findMin(root.leftChild);
      return root.key;
   }
   //插入元素
   public void insert(K key,V value){
      size++;
      root = insert(key,value,root);
   }
   private Node insert(K key,V value, Node root) {
      if(root == null)
         return new Node(key,value,null,null);
      if(root.key.compareTo(key)>0){
         root.leftChild = insert(key,value,root.leftChild);
      }
      else if(root.key.compareTo(key)<0){
         root.rightChild  = insert(key,value,root.rightChild);
      }
      return root;
   }
   //删除元素
   public Node remove(K key){
      size--;
      return remove(key,root);
   }
   private Node remove(K key, Node root) {
      if(root == null)
         return root;
      if(root.key.compareTo(key)>0){
         root.leftChild = remove(key,root.leftChild);
      }else if(root.key.compareTo(key)<0){
         root.rightChild = remove(key,root.rightChild);
      }else if(root.leftChild!=null&&root.rightChild!=null){//如果被删除节点有两个儿子
         //将删除节点，右子树的最小节点的值赋给root
         root.key = findMin(root.rightChild);
         //删除该节点的右子树的最小节点
         root.rightChild = remove(root.key,root.rightChild);
      }else {
         //如果被删除节点是一个叶子 或只有一个儿子
         root = root.leftChild!=null?root.leftChild:root.rightChild;
      }
      return root;
   }
   //清空二叉树
   public void clear(){
      size = 0;
      root = null;
   }
   //是否为空
   public boolean isEmpty(){
      return root == null;
   }
}
