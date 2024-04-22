package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/4/21
 */
public class Leetcode_134 {


    public int canCompleteCircuit(int[] gas, int[] cost) {

        // 首先我们需要明确一点，gas[i]是加油站，cost[i]是前往下一站花费的油
        // 那么如果全程中，加的所有油都不够走完全层，那么说明此题就没有解
        // 我们在循环的时候，其实也是在扩大判定区间，如果区间内的剩余油量加起来小于0，说明这个区间的任意一个地点出发，都无法正常走完一圈
        // 我们就可以开始更新开始地点


        // 走完全程时剩余的油量
        int totalRemainGas=0;

        int currenRemainGas=0;

        // 开始节点
        int startIndex=0;

        for (int i = 0; i < gas.length; i++) {
            totalRemainGas+=gas[i]-cost[i];
            currenRemainGas+=gas[i]-cost[i];
            if (currenRemainGas<0){
                startIndex=i+1;
                currenRemainGas=0;
            }

        }

        // 说明怎么走，油都不够走完一圈
        if (totalRemainGas<0){
            return -1;
        }

        return startIndex;


    }


}
