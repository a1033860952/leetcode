package leetcode_1000_2000;

import java.util.Arrays;

public class Leetcode_1155 {
    private static final int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {

        //我们需要先定义dp[i,j]，i是i个骰子，j是i个骰子投出的结果为j   数组的值就是有多个种可能i个骰子投出的结果为j
        //首先我们假设k是6,也就是骰子有6面，而n呢我们不具体设置数值
        //假设前面的骰子都投过了（答案先不用知道）， 现在我们需要投最后一个骰子了，如果投到了1，那么前面哪些骰子需要投到j-1才能达到j（这就是第一种可能）
        //如果最后一个骰子投到了2，那么前面的哪些骰子需要投到j-2才能达到j（这是第二种可能），以此类推。
        //在注意下这句话，前面的哪些骰子需要投到j-2才能达到j（那么前面哪些骰子需要投到j-1才能达到j），这个何尝不是一个子问题呢，子问题可以由更小的子问题日处理得到
        //没错，所以dp方程可以写成这样dp[i,j]=dp[i-1,j-1](投到1的可能)+dp[i-1,j-2]（投到2的可能）+...+dp[i-1,j-k](投到k的可能)，毕竟骰子有k面嘛

        //之前的是第一版dp，但是如果你用这个区处理此问题的话，不好意思超时了。。。。。
        //原因是因为你有很多计算是没有必要的了，比如我第一个骰子，他告诉我了我目标j，但是我投出了个x（骰子的数值）并发现这个数值比j还大，哪还有必要继续投吗
        //没必要了，因为已经没有意义了，无论后面的骰子投出多少都肯定不满足了
        //所以在递归往下循环的时候可以再加一个条件，x（骰子投出的数值）必须小于等于j才能往下走的可能



        long [][] dp=new long[n+1][target+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return (int) dfs(dp,n,k,target);

    }

    private long dfs(long[][] dp, int n, int k, int target) {
        long resultCount=0;

        for (int x = 1; x <= k && x<=target; x++) {
            if (n==1){
                if (target <=k){
//                    System.out.println("已经进到里面了 骰子为"+n+"  目标值为"+target+" 得到的结果是1"  );
                    //当只有一个骰子的时候，投出k以内的值的可能只有一种
                    return 1;
                }else {
//                    System.out.println("已经进到里面了 骰子为"+n+"  目标值为"+target+" 得到的结果是0"  );
                    //当只有一个骰子的时候，投出k以内的值的可能只有一种
                    return 0;
                }
            }


            if (dp[n-1][target-x]!=-1){
                resultCount=(resultCount+dp[n-1][target-x])%MOD;
                int tmp1=n-1;
                int tmp2=target-x;
//                System.out.println("获取dp属性 骰子为"+tmp1+"  目标值为"+tmp2 +" 得到的结果是"+dp[n-1][target-x]  );
            }else{
                int tmp1=n-1;
                int tmp2=target-x;
//                System.out.println("当前骰子数为"+n+"  当前骰子投出数为"+(x));
//                System.out.println("进一步计算 获取dp 骰子为"+tmp1+"  目标值为"+tmp2);
                long value = dfs(dp, n - 1, k, target - x);
                resultCount=(resultCount+value)%MOD;
            }
        }
        dp[n][target]=resultCount;
        return resultCount;

    }
}
