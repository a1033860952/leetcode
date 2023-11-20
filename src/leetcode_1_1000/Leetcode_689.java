package leetcode_1_1000;

public class Leetcode_689 {

    public static void main(String[] args) {
        int[] test={1,2,1,2,6,7,5,1};
        maxSumOfThreeSubarrays(test,2);
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //看题解看了3小时还是没能完全看懂，只能强写实践中理解了

        int length = nums.length;
        long[] sums=new long[length+1];

        //循环拿取累加值，并弄成一个数组,从1开始，0抛弃掉了不用这个
        for (int i = 1; i < nums.length; i++) {
            sums[i]=sums[i-1]+nums[i-1];
        }

        //？？ 不知道为啥要+10  +1不就好了吗
        long[][] dp=new long[length+10][4];

        //接下来就是循环获取dp
        for (int i=length-k+1;i>=0;i--){
            //循环3次
            for (int j=1;j<=4;j++){
                //i加一了
                long plusOneIdp = dp[i + 1][j];
                //
                long addKsubOneJdp = dp[i+k][j - 1];

                //用于获取这个不重叠数组的和
                long intervalNum = sums[i + k - 1] - sums[i - 1];

                //解释下这个dp的定义 ，比如dp[i][j]=x  则是前i个元素，组成的不重叠数组为j个时的最大值
                //这个是倒叙dp 当前值通过后面的dp值取出来的
                //我们接下来详细的解说下反序dp吧 正常我们的dp都是正序的，计算都从最小的开始计算，然后一步步计算到最大的
                //错的：但是反序dp不一样，反序dp是反着来的，一开始就算出了最后的，然后一步步推出前面的（其他的我不知道，但是在这里这个定义是错的）。
                //这里的反序dp是这样定义的，是完全反过来的，这里的反序dp的的定义是这样的
                //比如dp[i][j]=x  则是后length-i个元素，组成的不重叠数组为j个时的最大值  这才是这个反序dp的定义
                //所以到最后所需要给出的答案是dp[0][3],这个才是最后题目需要的答案
                dp[i][j]=Math.max(plusOneIdp,addKsubOneJdp+intervalNum);
            }

//
//            int[] ans = new int[3];
//            int i = 1, j = 3, idx = 0;
//            while (j > 0) {
//                if (dp[i + 1][j] > dp[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]) {
//                    i++;
//                } else {
//                    ans[idx++] = i - 1;
//                    i += k; j--;
//                }
//            }
//            return ans;


        }


        





        return nums;
    }

}
