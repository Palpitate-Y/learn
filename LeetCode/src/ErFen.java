/**
 * @author Palpitate Yzr
 */


public class ErFen {
    /*
   二分查找
给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。


示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1


提示：

你可以假设 nums中的所有元素是不重复的。
n将在[1, 10000]之间。
nums的每个元素都将在[-9999, 9999]之间。

*/
    public int search(int[] nums, int target) {
        //获取数组中间值 -1,0,3,5,9,12 获取nums[6(长度)/2]=num[3]=5
        //获取数组中间值 -1,0,3,5,9,  获取nums[5(长度)/2]=num[2]=3
        //循环递归比较中间值与目标值的大小 目标值 9  if 5==9 返回下标 else if 5<9 向右查找下标++  else 向左查找--

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /*
    x 的平方根
    给你一个非负整数 x ，计算并返回x的 算术平方根 。

    由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

    注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

    示例 1：
    输入：x = 4
    输出：2

    示例 2：
    输入：x = 8
    输出：2
    解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。

    提示：
    0 <= x <= 231 - 1
    */
    public int mySqrt(int x) {
    //取x的一半 如果x/2 * x/2==x 返回 否则 -1 再平方
    //如果x/2-1 * x/2-1 >x 且 x/2-2 * x/2-2<x 则返回x-2
        int left=0;
        int result=-1;
        int right=x;
        while (left <= right){
            int mid=(right-left)/2+left;
            //如果mid的平方小于x 向上查找 如果 等于或者大于向下查找
            if ((long)mid*mid<=x) {
                result=mid;
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return result;
    }
    public int mySqrt2(int x) {
        //取x的一半 如果x/2 * x/2==x 返回 否则 -1 再平方
        //如果x/2-1 * x/2-1 >x 且 x/2-2 * x/2-2<x 则返回x-2
        int left=0;
        int right=x;
        while (left<=right){
            int mid=(right-left)/2+left;
            long temp= (long) mid *mid;
            if (temp<x) left=mid+1;
            else if (temp>x) right=mid-1;
            else if (temp==x) return mid;
        }
        return right;
    }


    public static void main(String[] args) {
        ErFen erFen = new ErFen();
        int nums[] = {-1, 0, 3, 5, 9, 12};
        System.out.println(erFen.search(nums, 2));
    }
}
