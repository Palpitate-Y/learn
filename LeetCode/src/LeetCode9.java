/**
 * @author Palpitate Yzr
 */


/*
回文数
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

例如，121 是回文，而 123 不是。

示例 1：
输入：x = 121
输出：true

示例2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3：
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。

提示：
-231<= x <= 231- 1
进阶：你能不将整数转为字符串来解决这个问题吗？
*/

public class LeetCode9 {
    public boolean isPalindrome(int x) {
        String s= String.valueOf(x);
        String s2="";
        for (int i = s.length()-1; i >-1; i--) {
             s2+=s.charAt(i);
        }
        return s2.equals(s);
    }
    public boolean isPalindrome2(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }
    public boolean isPalindrome3(int x){
        //边界判断 如果传入的值是负数直接返回false
        if (x<0) return false;
        //除数 默认为1
        int div=1;
        //我们需要拿到x中的第一位数和最后一位数
        //为了获取第一位数 每当x除以div大于等于10 将除数×10
        //直到除数小于10 几个0也就知道了具体是几位数
        // 也就是说知道了x除以多少能拿到了第一位数
        while (x/div>=10){
            div*=10;
        }
        //将第一位数与最后一位数进行对比
        while (x>0){
            //第一位数
            int left=x/div;
            //最后一位数
            int right=x%10;
            //如果两个数不相等说明不是回文数返回false
            if (left!=right) return false;
            //如果相等 进行 第二位和倒数第二位的比较
            //也就是将最后一位数和第一位舍去
            // 比如x=21212 x%1000=1212 1212/10=121  然后将下一循环的除数/100
            // 121/100=1 121%10=1  100/100=1 >> 2    2/1=2 2%10=2 >> x=(2%1)/10=0 循环结束
            x=(x%div)/10;
        }
        return true;
    }
    public boolean isPalindrome4(int x) {
        /*
              x        revertedNumber
             1221          0
          /10      %10=1   +   0*10
           ↓               ↓
           122             1
          /10      %10=2   +   1*10
           ↓               ↓
           12              12
        x > revertedNumber 条件不成立 循环结束
                  ↓
    return x == revertedNumber || x == revertedNumber / 10;
                 true
                同理
              x        revertedNumber
             12321         0
          /10      %10=1   +   0*10
           ↓               ↓
           1232            1
          /10      %10=2   +   1*10
           ↓               ↓
           123             12
           /10      %10=3  +   12*10
           ↓               ↓
           12             123
      x > revertedNumber 条件不成立 循环结束
                  ↓
   return x == revertedNumber || x == revertedNumber / 10;
                 true
         */
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

public static void main(String[] args) {
    String s="-12345";
    System.out.println(s.charAt(0));
    System.out.println(s.indexOf("2"));
    LeetCode9 leetCode9=new LeetCode9();
    System.out.println(leetCode9.isPalindrome(121));
    System.out.println(2/1);
    System.out.println(2%10);
}
}
