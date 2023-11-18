import leetcode_2000_3000.Leetcode_2300;

import java.util.*;

/**
 * 测试专用，用于模拟无法理解的的问题，看看某个部分的结构是如何解决的
 */
public class test {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,3,4};

        int[] spells =new int[]{56029};
        int[] potions =new int[]{68460,46998,52655,39076,35323,92707,55922,89414};

        Leetcode_2300 leetcode2300=new Leetcode_2300();
        System.out.println(Arrays.toString(leetcode2300.successfulPairs(spells, potions, 99)));

        System.out.println(Arrays.toString(successfulPairs(spells, potions, 99)));
    }



    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long t = (success + spells[i] - 1) / spells[i] - 1;
            res[i] = m - binarySearch(potions, 0, m - 1, t);
        }
        return res;
    }

    public static int binarySearch(int[] arr, int lo, int hi, long target) {
        int res = hi + 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }





}
