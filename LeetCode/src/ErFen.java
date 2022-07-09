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

    public static void main(String[] args) {
        ErFen erFen = new ErFen();
        int nums[] = new int[]{3, 5, 3, 2, 0};
        //System.out.println(erFen.search(nums, 2));
        System.out.println(erFen.peakIndexInMountainArray(nums));
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
        int left = 0;
        int result = -1;
        int right = x;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            //如果mid的平方小于x 向上查找 如果 等于或者大于向下查找
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
/*
374. 猜数字大小
猜数字游戏的规则如下：

每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：

-1：我选出的数字比你猜的数字小 pick < num
1：我选出的数字比你猜的数字大 pick > num
0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
返回我选出的数字。

示例 1：
输入：n = 10, pick = 6
输出：6
示例 2：

输入：n = 1, pick = 1
输出：1
示例 3：

输入：n = 2, pick = 1
输出：1
示例 4：

输入：n = 2, pick = 2
输出：2

提示：
1 <= n <= 231 - 1
1 <= pick <= n
*/

    public int mySqrt2(int x) {
        //取x的一半 如果x/2 * x/2==x 返回 否则 -1 再平方
        //如果x/2-1 * x/2-1 >x 且 x/2-2 * x/2-2<x 则返回x-2
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long temp = (long) mid * mid;
            if (temp < x) left = mid + 1;
            else if (temp > x) right = mid - 1;
            else if (temp == x) return mid;
        }
        return right;
    }

    /*35. 搜索插入位置
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    请必须使用时间复杂度为 O(log n) 的算法。



    示例 1:

    输入: nums = [1,3,5,6], target = 5
    输出: 2
    示例 2:

    输入: nums = [1,3,5,6], target = 2
    输出: 1
    示例 3:

    输入: nums = [1,3,5,6], target = 7
    输出: 4


    提示:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums 为 无重复元素 的 升序 排列数组
    -104 <= target <= 104
    */
    public int searchInsert(int[] nums, int target) {
        //不在就插入，在就返回
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return right + 1;
    }

    /*852. 山脉数组的峰顶索引
    符合下列属性的数组 arr 称为 山脉数组 ：
    arr.length >= 3
    存在 i（0 < i < arr.length - 1）使得：
    arr[0] < arr[1] < ... arr[i-1] < arr[i]
    arr[i] > arr[i+1] > ... > arr[arr.length - 1]
    给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。



    示例 1：

    输入：arr = [0,1,0]
    输出：1
    示例 2：

    输入：arr = [0,2,1,0]
    输出：1
    示例 3：

    输入：arr = [0,10,5,2]
    输出：1
    示例 4：

    输入：arr = [3,4,5,1]
    输出：2
    示例 5：

    输入：arr = [24,69,100,99,79,78,67,36,26,19]
    输出：2


    提示：

    3 <= arr.length <= 104
    0 <= arr[i] <= 106
    题目数据保证 arr 是一个山脉数组


    进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？*/
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            }
        }
        return right;
    }
}
