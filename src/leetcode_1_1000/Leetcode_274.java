package leetcode_1_1000;

import java.util.Arrays;

public class Leetcode_274 {

    public int hIndex(int[] citations) {


        //翻译就是垃圾，看这段正确的 一名科研人员的 h 指数 是指他（她）至少发表了 h 篇 且至少 被引用 h 次的论文
        //dp[i]=j  i代表被引用的次数  j代表只是引用了i次的论文数是多少
        int[] dp=new int[1001];
        Arrays.fill(dp,0);

        for (int citation : citations) {
            for (int i = 0; i <= citation; i++) {
                if(dp[i]==i){
                    continue;
                }
                dp[i]=dp[i]+1;
            }
        }

        int value=0;

        for (int x = 0; x < dp.length; x++) {
            if (dp[x]==x){
                value=x;
            }

        }

        return value;








    }
}
