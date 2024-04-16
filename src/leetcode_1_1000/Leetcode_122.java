package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/4/15
 */
public class Leetcode_122 {

    public static void main(String[] args) {
        Leetcode_122 leetcode122=new Leetcode_122();
        leetcode122.maxProfit(new int[]{7,1,5,3,6,4});


    }

    public int maxProfit(int[] prices) {
        // 这是贪心解法
        // 题目说股票可以当前买入当天卖出，且同时只能持有一个股票，我们可以先把每天的利润计算出来，然后把每天的正利润加起来就可以了


        int length = prices.length;
        if (length<=1){
            return 0;
        }


        int result=0;
        int[] profitArray =new int[length -1];

        for (int i = 0; i < length-1; i++) {
            int profit = prices[i+1] - prices[i];
            profitArray[i]=profit;
        }
        for (int profit : profitArray) {
            if (profit>0){
                result+=profit;
            }

        }

        return result;


    }
}
