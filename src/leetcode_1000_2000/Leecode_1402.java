package leetcode_1000_2000;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Leecode_1402 {
    public static void main(String[] args) {
        int [] single = {4,3,2};

        System.out.println(maxSatisfaction(single));
    }

    public static int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);
        int finalResult=0;
        for (int i = 0; i < satisfaction.length-1; i++) {
            int time=1;
            int result=0;
            for (int j = i; j < satisfaction.length; j++) {
                result+=time*satisfaction[j];
                time++;
            }
            if (result>finalResult){
                finalResult=result;
            }

        }

        return finalResult;
    }
}
