/**
 * 此类用于观察题解代码
 */
class Solution {
    public int maximumSum(int[] nums) {
        int[][] val = new int[100][2];
        for (int x : nums) {
            int t = x, cur = 0;
            while (t != 0) {
                cur += t % 10;
                t /= 10;
            }
            if (x >= val[cur][1]) { // 最大沦为次大, 更新最大
                val[cur][0] = val[cur][1];
                val[cur][1] = x;
            } else if (x > val[cur][0]) { // 更新次大
                val[cur][0] = x;
            }
        }
        int ans = -1;
        for (int i = 0; i < 100; i++) {
            if (val[i][0] != 0 && val[i][1] != 0) ans = Math.max(ans, val[i][0] + val[i][1]);
        }
        return ans;
    }
}
