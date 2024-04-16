package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/4/2
 */
public class Leetcode_376 {


    public int wiggleMaxLength(int[] nums) {

        // 首先题目说的是需要摆动序列 的 最长子序列的长度 ，且我们可以任意删除元素来组成子序列
        // 但是其实我们不需要真的删除，我们返回的只是一个int长度而已
        // 当 仅有一个元素或者含两个不等元素的序列也视作摆动序列

        if(nums.length<=1){
            return nums.length;
        }

        int curDiff = 0;
        int preDiff = 0;

        // 为什么result一开始是1呢,最开始我们上面是有个判断长度的,能走到这里说明数组长度至少是2
        // 就算这个数组长度为2,且是平坡,那么答案就是1,因为题干中说仅有一个元素也视作摆动序列

        // 然后就是在计算过程中,我们在计算prediff和curdiff时,至少要有三个数,才能正常算出这两个值,但是如果只有两个值呢
        // 如果只有两个值,我们可以当做三个值来处理,比如是原来是1,2  的  我们可以假设是1,1,2,然后prediff一开始初始化为0的,而1-1刚好是0嘛
        // 这样就和我们的下面的规则对上了
        int result = 1;
        for (int i = 0; i < nums.length-1; i++) {
            curDiff=nums[i+1]-nums[i];
            if ((preDiff<=0 && curDiff>0) || (preDiff>=0 && curDiff<0) ){
                result++;
                preDiff=curDiff;

            }
        }

        return result;
    }


}
