package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/4/15
 */
public class Leetcode_53 {

    public static void main(String[] args) {

        Leetcode_53 leetcode53=new Leetcode_53();
        System.out.println(leetcode53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

    }


    public int maxSubArray(int[] nums) {
        // 这题可以使用贪心算法来实现，贪心在哪里呢
        // 当发现这个sum值为负数，马上将起点移到下一个数值，因为如果负数+正数得到的值永远比正数小，那干啥不从正数开始
        // 这道题就是基于这个原理实现的


        int result=Integer.MIN_VALUE;
        int currentSum=0;
        for (int i = 0; i < nums.length; i++) {
            currentSum+=nums[i];
            if (currentSum>result){
                result=currentSum;
            }
            if (currentSum<0){
                currentSum=0;
            }

        }
        return result;
    }

}
