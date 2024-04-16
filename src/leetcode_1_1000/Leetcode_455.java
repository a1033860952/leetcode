package leetcode_1_1000;

import java.util.Arrays;

/**
 * @author tianling
 * @description:
 * @since 2024/3/31
 */
public class Leetcode_455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sIndex=s.length-1;
        int result=0;
        for (int i = g.length-1; i >= 0; i--) {
            if (sIndex<0){
                break;
            }

            if (s[sIndex]>=g[i]){
                result++;
                sIndex--;
            }
        }

        return result;

    }
}
