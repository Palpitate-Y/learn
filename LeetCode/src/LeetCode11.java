/**
 * @author Palpitate Yzr
 */
public class LeetCode11 {
    public static void main(String[] args) {
        LeetCode11 leetCode11=new LeetCode11();
        int[] array={1};
        System.out.println(leetCode11.cost(array));
    }

    /*11. 盛最多水的容器
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。



示例 1：



输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
示例 2：

输入：height = [1,1]
输出：1


提示：

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/
    public int maxArea(int[] height) {
        //双指针遍历找面积最大值（长乘宽，两个边更短的长乘间距）
        int i=0,j=height.length-1;
        int result=0;
      /*  while (j>i){
            //判断更短的长 用更短的长求面积 循环比较面积更大的值
            if (height[j]<height[i]){
                result=Math.max(result,(j-i)*height[j--]);
            }else{
                result=Math.max(result,(j-i)*height[i++]);
            }
        }*/
        while (j>i){
            result=height[j]<height[i]?
                    Math.max(result,(j-i)*height[j--]):
                    Math.max(result,(j-i)*height[i++]);
        }
        return result;

    }

    public int cost (int[] array) {
        // write code here
        int count=0;
        int meansure=0;
        int min=0;
        int len=array.length;
        for(int i=1;i<len;i++)
        {
            if(array[i]>array[i-1])
                meansure++;
            else if(array[i]<array[i-1])
                meansure--;
            count+=meansure;
            min=Math.min(min,meansure);
        }
        if(min<0)
            count+=Math.abs(min)*len;
        count+=len;
        return count;
    }
}
