import java.util.HashMap;

/**
 * @author Palpitate Yzr
 */
/**
 *
 * 无重复字符的最长子串
 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class StringTest {
    public static void main(String[] args) {
        StringTest stringTest=new StringTest();
        System.out.println(stringTest.lengthOfLongestSubstring("ascdescdd"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {

            if (map.containsKey(s.charAt(end))) {
                //如果map包含当前在i位置的字符
                // 则left等于 left和当前在i位置的字符的value+1中的最大值
                // +1代表从当前位置之后开始不重复
                // 返回上一个重复字符的下一个位置
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            //如果map不包含 将key位置存放字符串s第i位置的字符 value位置存放i
            // 加入新的字符， 遇到重复的字符会更新在map中的value值，即重复字符的最新下标
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
        }
        return max;

    }
}
