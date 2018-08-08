package DataStructure.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liubaoqing
 * @createTime 2018-08-06
 * @description
 */
/**
 * 这里的算法类似简单的插入排序：
 * 取出字符串中的第i个字符，依次和前未出现重复的字符进行比较，如果找到相同字符，则计算出第(i-1)个字符到相同字符之间的字符数
 * 例如：  0 1 2 3 4 5 6 7 8 9 10
 *  s="    q o p u b j g u x h x ";
 * 第一次遍历，找到出现重复字符的位置 7->u,计算出前面未出现重复字符串的长度为 7，
 * 并记录找到的前面被重复字符下一个字符的位置（4->b）,做为下一次遍历的终点
 * 继续取第 8 个字符x,依次与前面的字符比较，一直到第 4 个字符b,
 * 继续取第 9 个字符h进行遍历到第4个字符b
 * 继续取第10个字符x进行遍历到第8个字符，出现重复，则记录第8个字符到第4个字符的长度为 5，
 * 比较子字符串长度，记录下较长的长度值
 */
public class lengthOfLongestSubstring {
   @Test
   public void test(){
      System.out.println(longestIncreasingContinuousSubsequence("pwwkew"));
   }
   public static int lengthOfLongestSubstring(String s) {
      int strLength = s.length();
      int maxLength = -1;
      int start = 0;
      for (int i = 1; i < strLength; i++) {
         char temp = s.charAt(i);
         for (int j = i; j > start; j--) {
            if (s.charAt(j-1)== temp) {
               maxLength = (maxLength >(i-start))?maxLength:(i-start);
               start = j;
            }
         }
      }
      //若最后一次遍历没有重复的字符，则将最后一次遍历的长度和之前的最长子串长度进行比较
      maxLength = (maxLength >(strLength-start))?maxLength:(strLength-start);
      return maxLength;
   }
   public static int maxLenthNoRepeat(String str){
      if(str==null || str.isEmpty()){
         return 0;
      }
      Map<Character, Integer> map = new HashMap<Character, Integer>();
      int maxLength = 0;
      int current = 0;

      //循环字符串，取出每个字符
      for(int index=0; index < str.length(); index++){
         if(map.containsKey(str.charAt(index))){
            current = map.get(str.charAt(index)) + 1;
         }
         else{
            if((index-current+1)>maxLength){
               maxLength=index-current+1;
            }
         }
         map.put(str.charAt(index), index);
      }

      return maxLength;
   }
   /**动态规划*/
   public static int longestIncreasingContinuousSubsequence(String str) {
      if(str==null){
         return 0;
      }
      int increasingResult=1;
      int currentIncreasingResult=1;
      char [] array=str.toCharArray();
      for(int i=1;i<array.length;i++) {
         //最长连续递增
         if(array[i]==array[i-1]+1) {
            currentIncreasingResult++;
         }else {
            currentIncreasingResult=1;
         }
         increasingResult=Integer.max(increasingResult, currentIncreasingResult);
      }
      return increasingResult==1?0:increasingResult;
   }
}
