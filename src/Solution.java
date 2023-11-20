class Solution {

    public static void main(String[] args) {
        int[] test={1,2,1,2,6,7,5,1};
        maxSumOfThreeSubarrays(test,2);

    }
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        long[] sum = new long[n + 1];

        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];

        long[][] f = new long[n + 10][4];

        //dp算法
        for (int i = n - k + 1; i >= 1; i--) {
            for (int j = 1; j < 4; j++) {
                //i加一了
                long plusOneIdp = f[i + 1][j];
                //
                long addKsubOneJdp =  f[i + k][j - 1];

                //用于获取这个不重叠数组的和
                long intervalNum = sum[i + k - 1] - sum[i - 1];
                f[i][j] = Math.max(f[i + 1][j], f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]);
            }
        }

        int[] ans = new int[3];
        int i = 1, j = 3, idx = 0;
        while (j > 0) {
            long test = f[i + 1][j];
            long test1 = f[i + k][j - 1];
            long test2 = sum[i + k - 1];
            long test3 = sum[i - 1];
            if (f[i + 1][j] > f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]) {
                i++;
            } else {
                ans[idx++] = i - 1;
                i += k; j--;
            }
        }
        return ans;
    }
}
