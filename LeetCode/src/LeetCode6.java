import java.util.ArrayList;
import java.util.List;

/**
 * @author Palpitate Yzr
 */


/*  Z 字形变换
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。

比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：

输入：s = "A", numRows = 1
输出："A"

提示：
1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000
*/
public class LeetCode6 {
    /*
       解题思路参考力扣 Krahets
       思路解析
    *  例如 LeetCode 三行
    *  L   C
    *  E T O E
    *  E   D
    *
    * 分为三个字符串数组 r[0] r[1] r[2]
    * 依次将其加入字符串数组，i=0开始循环 当循环3遍 也就是i==2时 r0=l r1=e r2=e
    * 此时将自加值变为负数，使其反向循环 所以 r1=et r0=lc
    * 此时i归0，我们再次将其自加值反转变为正数，所以 r1=eto r2=ed 此时回到i==2的情况
    *
    * 最后将三个数组的字符串进行拼接得到 lcetoeed
    * */
    public String convert(String s, int numRows) {
        //如果行数小于2 直接返回s
        if (numRows<2) return s;
        List<StringBuilder> sb = new ArrayList<>();
        //获取传入行数个数的字符串数组
        for (int i = 0; i < numRows; i++) {
            sb.add(new StringBuilder());
        }
        int i=0,flag=-1;
        //遍历字符串中的每一个字符  toCharArray():将字符串转换为字符数组
        for (char c:s.toCharArray()) {
            sb.get(i).append(c);
            //当i来到两个边界值时，使flag反转
            if (i==0||i==numRows-1){
                flag=-flag;
            }
            i+=flag;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            stringBuilder.append(sb.get(j));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LeetCode6 leetCode6=new LeetCode6();
        System.out.println(leetCode6.convert("LeetCode",3));;
    }
}
