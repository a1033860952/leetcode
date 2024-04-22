package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/4/17
 */
public class Leetcode_45 {

    public int jump(int[] nums) {

        // 这题我们使用贪心算法来实现，我们可以用两步范围去判断，若两步范围内的最大值都没能覆盖终点
        // 那么就说明无法只走两步是无法达到的，然后可以拿到当前两步范围内的最大值
        // 然后再重复上面步骤，最后就能得到结果

        int length = nums.length;
        if (length==1){
            return 0;
        }


        int count = 0;
        // 当前所能覆盖的最远距离下标
        int currentDistance=0 ;

        // 下一步所能覆盖的最远距离下标
        int nextDistance=0;


        for (int i = 0; i < nums.length; i++) {
            // 更新下一步覆盖最先距离
            nextDistance=Math.max(nums[i]+i,nextDistance);

            // 当前走到了覆盖最远距离
            if (i==currentDistance){
                count++;

                currentDistance=nextDistance;

                //修改当前覆盖最远距离
                if (nextDistance>=length-1){
                    break;
                }
            }
        }
        return count;
    }
}
