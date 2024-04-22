package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/4/17
 */
public class Leetcode_55 {
    public static void main(String[] args) {
        Leetcode_55 leetcode55=new Leetcode_55();
        leetcode55.canJump(new int[]{3,2,1,0,4});


    }



    public boolean canJump(int[] nums) {
        //使用贪心算法解决
        // 我们可以拿到拿到所有元素的最大覆盖范围地址，然后判断有没有能到达的数组长度
        // 有就说明可以解决


        int length = nums.length;
        if (length<=1){
            return true;
        }


        int maxRange=1;
        for (int i = 0; i < maxRange; i++) {
            int num = nums[i];
            int currentMaxRange = i + num + 1;
            if (currentMaxRange >=length){
                return true;
            }
            if (currentMaxRange>maxRange){
                maxRange=currentMaxRange;
            }


        }
        return false;
    }

}
