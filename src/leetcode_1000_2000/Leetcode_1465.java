package leetcode_1000_2000;

import java.util.Arrays;

public class Leetcode_1465 {

    private static final int MOD = 1_000_000_007;

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        //这题其实很简单，我们本质上其实就是求horizontal（两天条线之间的最大间隔）和vertical（两条线之间的最大间隔）
        //然后注意最开始和最后也是有间隔的

        int horizontalValue = getMaxInterval(h, horizontalCuts);
        int verticalValue = getMaxInterval(w, verticalCuts);

        return (int)((long) horizontalValue * verticalValue % MOD);

    }

    private int getMaxInterval(int max, int[] cuts) {
        //先获取开始间隔 和结束间隔那个更大一点
        int length = cuts.length;
        Arrays.sort(cuts);
        int result=0;
        if (length==1){
            result = Math.max(cuts[0],max-cuts[0]);
        }else{
            result = Math.max(cuts[0], max-cuts[length - 1]);

        }
        for (int i = 0; i < length; i++) {
            int leftLocation=i;
            int rightLocation=i+1;
            if (rightLocation>= length){
                break;
            }
            int leftValue = cuts[leftLocation];
            int rightValue = cuts[rightLocation];
            if (rightValue-leftValue>result){
                result=rightValue-leftValue;
            }

        }


        return result;
    }
}
