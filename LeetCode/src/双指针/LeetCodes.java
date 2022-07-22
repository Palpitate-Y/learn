package 双指针;

import java.util.Arrays;

/**
 * @author Palpitate Yzr
 */
public class LeetCodes {
    public static void main(String[] args) {
        LeetCodes leetCodes = new LeetCodes();
        int[] numbers = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(leetCodes.twoSum(numbers, 9)));

    }

    /*
      167. 两数之和 II - 输入有序数组

     给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
     请你从数组中找出满足相加之和等于目标数 target 的两个数。
     如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
     则 1 <= index1 < index2 <= numbers.length 。
     以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     你所设计的解决方案必须只使用常量级的额外空间。

     示例 1：
     输入：numbers = [2,7,11,15], target = 9
     输出：[1,2]
     解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。

     示例 2：
     输入：numbers = [2,3,4], target = 6
     输出：[1,3]
     解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。

     示例 3：
     输入：numbers = [-1,0], target = -1
     输出：[1,2]
     解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。

     提示：
     2 <= numbers.length <= 3 * 104
     -1000 <= numbers[i] <= 1000
     numbers 按 非递减顺序 排列
     -1000 <= target <= 1000
     仅存在一个有效答案

     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        //左右元素开始互加 如果等于target返回 元素相等时停止循环
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            if (sum < target) left++;
            if (sum > target) right--;
        }
        return result;
    }

    /*633. 平方数之和
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
示例 1：
输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5
示例 2：
输入：c = 3
输出：false
提示：
    0 <= c <= 231 - 1

*/
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            //根号x往上的相加没有意义 ，所以右指针直接设置为根号x
            long sum = (long) a * a + (long) b * b;
            if (sum == c) return true;
            if (sum < c) a++;
            if (sum > c) b--;
        }
        return false;
    }

    /*680. 验证回文字符串 Ⅱ
    给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

    示例 1:
    输入: s = "aba"
    输出: true

    示例 2:
    输入: s = "abca"
    输出: true
    解释: 你可以删除c字符。

    示例 3:
    输入: s = "abc"
    输出: false

    提示:
        1 <= s.length <= 105
        s 由小写英文字母组成
    */
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalind(s, left, right - 1) || isPalind(s, left + 1, right);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isPalind(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    /*524. 通过删除字母匹配到字典里最长单词
    给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
    如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
    
    示例 1：
    输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
    输出："apple"
    
    示例 2：
    输入：s = "abpcplea", dictionary = ["a","b","c"]
    输出："a"

    提示：
        1 <= s.length <= 1000
        1 <= dictionary.length <= 1000
            String res = "";
            for (String t : dictionary) {
                int i = 0, j = 0;
                while (i < t.length() && j < s.length()) {
                    if (t.charAt(i) == s.charAt(j)) {
                        ++i;
                    }
                    ++j;
                }
                if (i == t.length()) {
                    if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                        res = t;
                    }
                }
            }
            return res;        1 <= dictionary[i].length <= 1000
        s 和 dictionary[i] 仅由小写英文字母组成
    */

        /*        String word="";
        for (String s1 : dictionary) {
            int l1=word.length(),l2=s1.length();
            if (l1>l2 || (l1==l2 && word.compareTo(s1)<0)){
                continue;
            }
            if (isSubstr(s,s1)){
                word=s1;
            }
        }
        return word;*/


/*    private boolean isSubstr(String s, String s1) {
        int j=0;
        for (int i = 0; i < s.length()&&j<s1.length(); i++) {
            if (s.charAt(i)==s1.charAt(j)){
                j++;
            }
        }
        return j==s1.length();
    }*/

    /*88. 合并两个有序数组

    给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
    注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
    为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

    示例 1：

    输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    输出：[1,2,2,3,5,6]
    解释：需要合并 [1,2,3] 和 [2,5,6] 。
    合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。

    示例 2：
    输入：nums1 = [1], m = 1, nums2 = [], n = 0
    输出：[1]
    解释：需要合并 [1] 和 [] 。
    合并结果是 [1] 。

    示例 3：
    输入：nums1 = [0], m = 0, nums2 = [1], n = 1
    输出：[1]
    解释：需要合并的数组是 [] 和 [1] 。
    合并结果是 [1] 。
    注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。

    提示：
        nums1.length == m + n
        nums2.length == n
        0 <= m, n <= 200
        1 <= m + n <= 200
        -109 <= nums1[i], nums2[j] <= 109
    进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int sum = m + n - 1;
        while (index2 >= 0) {
            //如果nums1或nums2数组无数据 则直接插入，也就是把另一个数组插入在后面
/*         if (index1<0)
         {
             while (index2>=0){
                 nums1[sum--]=nums2[index2--];
             }
             continue;
         }*/
            //比较大小 进行插入
            if (index1 < 0) nums1[sum--] = nums2[index2--];
                //else if (index2 < 0) nums1[sum--] = nums1[index1--];
            else if (nums1[index1] > nums2[index2]) nums1[sum--] = nums1[index1--];
            else nums1[sum--] = nums2[index2--];
        }
    }
}
