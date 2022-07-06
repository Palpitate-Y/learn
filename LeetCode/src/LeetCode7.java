/**
 * @author Palpitate Yzr
 */
/*
整数反转
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围[−2 31, 2 31 −1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。

示例 1：
输入：x = 123
输出：321

示例 2：
输入：x = -123
输出：-321

示例 3：
输入：x = 120
输出：21

示例 4：
输入：x = 0
输出：0

提示：
-231 <= x <= 231 - 1
*/
public class LeetCode7 {
    public int isPalindrome2(int x) {
        if (x<10&&x>=0) return x;
        //int的最小值为 -2147483648 最大值为2147483647
        if (x>-2147483647) {
            if (x%10==0) x/=10;
            if (x<0){
                x=-x;
                String reversedStr = (new StringBuilder(x + "")).reverse().toString();
                if (Long.parseLong(reversedStr)<2147483647) {
                    int i = Integer.parseInt(reversedStr);
                    return -i;
                }
                else return 0;
            }
            String reversedStr = (new StringBuilder(x + "")).reverse().toString();
            if (Long.parseLong(reversedStr)<2147483647) return Integer.parseInt(reversedStr);
            else return 0;
        }
       else return 0;
    }
    public int reverse(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10)  {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode7 leetCode7=new LeetCode7();
        System.out.println(leetCode7.isPalindrome2(1247483647));
        int i=-2147483648;
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(leetCode7.reverse(2147483641));
    }
}
