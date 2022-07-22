package 回溯;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Palpitate Yzr
 */
/*78. 子集
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]*/
public class LeetCode78 {
    //全集合
    List<List<Integer>> allPath=new LinkedList<>();
    //子集
    List<Integer> path=new LinkedList<>();
    public static void main(String[] args) {
        LeetCode78 leetCode78=new LeetCode78();
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }
        //int[] nums=new int[]{1,2,3,4};
/*        leetCode78.permute(nums);
        System.out.println(leetCode78.allPath.toString());*/
        List<List<Integer>> zj = leetCode78.zj(nums);
        System.out.println(zj.toString());
    }
    public List<List<Integer>> zj(int[] nums){
        back(0,nums);
        return allPath;
    }

    private void back(int count, int[] nums) {
        //遍历到叶子节点 则加入全集
        allPath.add(new LinkedList<>(path));
        for (int i = count; i < nums.length; i++) {
/*            if (path.contains(nums[i])){
                continue;
            }*/
            //加入当前路径
            path.add(nums[i]);
            //递归
            back(i+1,nums);
            //回溯节点
            path.remove(path.size()-1);

        }
    }


    public List<List<Integer>> permute(int[] nums){
        //子集
        List<Integer> path=new LinkedList<>();
        //进入递归 寻找子集  回溯
        backTrace(nums,path);
        return allPath;
    }

    private void backTrace(int[] nums, List<Integer> path) {
        //当path路径长度等于nums的长度，表示走到叶子结点，该子集寻找结束，加到全集中
        if (nums.length==path.size()){
            allPath.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //剪去已经走过的路径
            if (path.contains(nums[i])){
                continue;
            }
            //加入当前路径
            path.add(nums[i]);
            //进入第二层选择
            backTrace(nums, path);
            //取消选择 回到上个节点
            path.remove(path.size()-1);
        }
    }


}
