package 排序;

import java.util.Arrays;

/**
 * @author Palpitate Yzr
 */
public class PaiXu {
    // 归并排序
    int[] tmp;
    //插入排序
/*    public void sortChaRu(int[] nums){
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >0 &&nums[j]<nums[j-1] ; j--) {
                swap
            }
        }
    }*/

    public static void main(String[] args) {
        PaiXu maoPao=new PaiXu();
        int[] nums=new int[]{2,1,3,4,0,-1};
        maoPao.sortMaoPao(nums);
        System.out.println(Arrays.toString(nums));
    }

    //冒泡排序
    public void sortMaoPao(int[] nums){
        int n= nums.length;
        boolean isSorted=false;
        for (int i = n-1; i >0 && !isSorted ; i--) {
            isSorted=true;
            for (int j = 0; j < i; j++) {
                if (nums[j+1]<nums[j]){
                    isSorted=false;
                    int temp=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        // 去中间值
        int mid = l + (r - l) / 2;
        //int mid = (l + r) >> 1;
        //对半数组 左到中
        mergeSort(nums, l, mid);
        //中到右
        mergeSort(nums, mid + 1, r);
        //从左到 重算中值
        int i = l, j = mid + 1;
        int cnt = 0;
        //当 从左到中  且  从中到右
        while (i <= mid && j <= r) {
            //从小到大依次添加入数组
            //如果左值小于等于右值
            if (nums[i] <= nums[j]) {
                //中间数组 得到（更小的值） 左值 左++
                tmp[cnt++] = nums[i++];
            } else {
                //大于
                //中间数组得到 （更小的值） 右值 右++
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }
}
