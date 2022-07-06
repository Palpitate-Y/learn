

/**
 * @author Palpitate Yzr
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 两数之和
 *
 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

 你可以按任意顺序返回答案。

  

 示例 1：

 输入：nums = [2,7,11,15], target = 9
 输出：[0,1]
 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 示例 2：

 输入：nums = [3,2,4], target = 6
 输出：[1,2]
 示例 3：

 输入：nums = [3,3], target = 6
 输出：[0,1]
  

 提示：

 2 <= nums.length <= 104
 -109 <= nums[i] <= 109
 -109 <= target <= 109
 只会存在一个有效答案

 */

public class Test {
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int expect = target - num;
            if (map.containsKey(expect)) {
                result[0] = map.get(expect);
                result[1] = i;
                break;
            } else {
                map.put(num, i);
            }
        }
        return result;
    }
    public List<Integer> distinct(List<Integer> arr){
        Stream<Integer> distinct = arr.stream().distinct();
        List<Integer> collect = distinct.collect(Collectors.toList());
        return collect;
    }
    public List<Integer> distinct2(List<Integer> arr){
        HashSet set = new HashSet(arr);
        Iterator it = set.iterator();
        List<Integer> list=new ArrayList<>();
        while (it.hasNext()){
            list.add((Integer) it.next());
        }
        return list;
    }
    public List<Integer> distinct3 (List<Integer> arr){
        Set<Integer> set = new HashSet(arr);
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 4, 5};
        int target = 9;
        Test test = new Test();
        List<Integer> arr= Arrays.asList(1,10,100,10,1);
        arr= test.distinct3(arr);
        for (Integer i : arr) {
            System.out.println(i+"");
        }
        System.out.println(Arrays.toString(test.twoSum(nums, target)));
        System.out.println(Arrays.toString(test.twoSum2(nums, target)));
    }

}

