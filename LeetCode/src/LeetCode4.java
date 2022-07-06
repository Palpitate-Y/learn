/**
 * @author Palpitate Yzr
 */

import java.util.ArrayList;
import java.util.Arrays;

/*
寻找两个正序数组的中位数

给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
        算法的时间复杂度应该为 O(log (m+n)) 。
        示例 1：
        输入：nums1 = [1,3], nums2 = [2]
        输出：2.00000
        解释：合并数组 = [1,2,3] ，中位数 2
        示例 2：
        输入：nums1 = [1,2], nums2 = [3,4]
        输出：2.50000
        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        提示：
        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -106 <= nums1[i], nums2[i] <= 106
*/
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //中间数组
            int[] nums;
            int m = nums1.length;
            int n = nums2.length;
            nums = new int[m + n];
            //边界情况 如果m或者n的长度为0
            if (m == 0) {
                if (n % 2 == 0) {
                    return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
                } else {

                    return nums2[n / 2];
                }
            }
            if (n == 0) {
                if (m % 2 == 0) {
                    return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
                } else {
                    return nums1[m / 2];
                }
            }
            //正常情况
            int count = 0;
            int i = 0, j = 0;
            //循环 直到中间数组添加到m+n的长度
            while (count != (m + n)) {
                //如果i遍历完数组1 且j还没有遍历完数组2
                //将数组2的第j个值赋值给中间变量 也就是中间数组的后续所有元素都是数组2的
                if (i == m) {
                    while (j != n) {
                        nums[count++] = nums2[j++];
                    }
                    break;
                }
                //如果j遍历完数组2 且i还没有遍历完数组1
                //将数组1的第i个值赋值给中间变量 也就是中间数组的后续所有元素都是数组1的
                if (j == n) {
                    while (i != m) {
                        nums[count++] = nums1[i++];
                    }
                    break;
                }
                //如果数组1中的第i个值小于数组二中的第j个值
                //将数组1的第i个值赋值给中间数组
                //否则将数组2的j个值赋值给中间数组
                //ps：将更小的值赋值给中间数组
                if (nums1[i] < nums2[j]) {
                    nums[count++] = nums1[i++];
                } else {
                    nums[count++] = nums2[j++];
                }
            }
            //此时count=m+n 也就是中间数组的长度
            //如果count被2整除 则为数组长度为奇数 取数组中间数和中间数-1的平均数
            //如果是偶数 取数组中间数的值
            //比如[1,2,3,4,5] 数组长度为5 奇数取5/2向下取整也就是num[2] 为数组中的第三个值 3
            //比如[1,2,3,4] 数组长度为4 偶数取4/2和4/2-1也就是num[2]和num[1] 为数组中的第三个值 3和第二个数2的平均数 为（3+2）/2=2.5
            if (count % 2 == 0) {
                return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
            } else {
                return nums[count / 2];
            }
        }
}
