import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Palpitate Yzr
 */
public class JOffer {
    public int findRepeatNumber(int[] nums) {
        HashSet<Object> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (hashSet.contains(nums[i])) {
                return nums[i];
            } else {
                hashSet.add(nums[i]);
            }
        }
        return -1;
    }
    /*
实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
*/
    public String replaceSpace(String s) {
        //遍历字符串
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

}
