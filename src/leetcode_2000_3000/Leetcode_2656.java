package leetcode_2000_3000;

import java.util.Arrays;

public class Leetcode_2656 {

    public int maximizeSum(int[] nums, int k) {

        Arrays.sort(nums);
        int result=0;
        for (int i = 0; i < k; i++) {
            int tmp = nums[nums.length - 1];
            result+= tmp;
            nums[nums.length-1]=tmp+1;
            Arrays.sort(nums);
        }

        return result;
    }
}
