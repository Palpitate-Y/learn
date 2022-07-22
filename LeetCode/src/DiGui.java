import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Palpitate Yzr
 */
public class DiGui {
    /*
     * 25>2+5=7
     * 665>6+6+5=17>1+7=8
     * */
    public int solution(int x) {
        //获得x的所有位数 如果是个位数（<10）进行返回
        //每一个位数进行相加 得数>10 递归 直到＜10返回
        if (x < 10) return x;
        int result = 0;
        // %10获得个位数  /10获得前面几位数 （如果这个数>10 再次%10 /10）
        //17 result>10 递归
        while (x > 0) {
            result += x % 10;
            x = x / 10;
        }
        if (result>10){
           return this.solution(result);
        }
        return result;
    }
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        DiGui diGui=new DiGui();
        System.out.println(diGui.solution(823988));
        System.out.println(diGui.diG(10, 1));
        int nums[] =new int[]{1,2,3};
        int numsk[] =new int[]{1,2,3,4,5,6,7};
        diGui.rotate(numsk,3);
        System.out.println(Arrays.toString(numsk));
        List<List<Integer>> subsets = diGui.subsets(nums);
        System.out.println(subsets.toString());
    }

    public int diG(int i,int count){
        while (count!=8){
            i+=2;
            count++;
            diG(i,count);
        }
       return  i;
    }

    public int bi(String s1, String s2){
        if (s1==null || s2==null) throw new RuntimeException();
        String[] sA1 = s1.split("\\.");
        String[] sA2 = s1.split("\\.");
        int idx = 0;
        int minLength = Math.min(sA1.length, sA2.length);//取最小长度值
        int diff = 0;
        while (idx < minLength
                && (diff = sA1[idx].length() - sA2[idx].length()) == 0//先比较长度
                && (diff = sA1[idx].compareTo(sA2[idx])) == 0) {//再比较字符
            idx++;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : sA1.length - sA2.length;
        return diff;
 }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public void rotate(int[] nums, int k) {
        int n=nums.length;
        //6---0 5---1 4----2 3---3 6-3 %3
        int[] nums2=new int[n];
        for(int i=0;i<nums.length;i++){
            nums2[(i+k)%n]=nums[i];

        }
        System.arraycopy(nums2,0,nums,0,n);
    }

    public void rotate2(int[] nums, int k) {
        //123456
        //654321
        //456123
        int n=nums.length;
        k %=n;
        //反转全部 0到n-1
        reverse(nums,0,n-1);
        //反转0到k-1
        reverse(nums,0,k-1);
        //反转k到n-1
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums,int start,int end){
        //反转数组 头尾交换
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            end--;
            start++;
        }
    }
}
