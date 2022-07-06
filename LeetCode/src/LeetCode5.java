import java.util.HashMap;

/**
 * @author Palpitate Yzr
 */
public class LeetCode5 {
    /*
最长回文子串

给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：
输入：s = "cbbd"
输出："bb"
提示：
1 <= s.length <= 1000
s 仅由数字和英文字母组成
*/

        public boolean isPalindromic (String s){
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - i - 1)) {
                    return false;
                }
            }
            return true;
        }
// 暴力解法
        public String longestPalindrome(String s) {
            String ans = "";
            int len = s.length();
            for(int i=len;i>1;i--){
                //检索的串的长度为i
                for(int j=0;j+i-1<len;j++){
                    //检索串的起始位置
                    String s1=s.substring(j,j+i);
                    if(isPalindromic(s1)){
                        ans=s1;
                        return ans;
                    }
                }
            }
            return s.substring(0,1);
        }
    public String longestPalindrome2(String s) {
        int length = s.length();
        //建立二维数组
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;//中间量
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;
    }


    public static void main(String[] args) {
        LeetCode5 leetCode5=new LeetCode5();
        System.out.println(leetCode5.longestPalindrome("baaaaaaab"));
        System.out.println(leetCode5.longestPalindrome2("baaaaaaab"));
    }
}
