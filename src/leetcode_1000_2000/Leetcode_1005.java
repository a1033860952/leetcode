package leetcode_1000_2000;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tianling
 * @description:
 * @since 2024/4/21
 */
public class Leetcode_1005 {


    public static void main(String[] args) {
        Leetcode_1005 leetcode1005=new Leetcode_1005();
        System.out.println(leetcode1005.largestSumAfterKNegations(new int[]{4,2,3}, 1));

    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        //使用贪心思想解决，先对数据进行排序，根据绝对值排序
        // 优先将负的全转换为正的，当没有父的元素时，持续转换数值最低值

        int[] soredNumArray = Arrays.stream(nums).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2) - Math.abs(o1);
            }
        }).mapToInt(Integer::intValue).toArray();


        for (int i = 0; i < soredNumArray.length; i++) {

            int value = soredNumArray[i];
            if (value<=0 && k>0){
                soredNumArray[i]=-value;
                k--;
            }
        }

        // 这里为什么我们要%2呢，因为如果k还是2的话，最后结果是一样的，没啥意义，毕竟我们一直在转换最小的那个值
        if (k%2==1){
            soredNumArray[nums.length-1]=-soredNumArray[nums.length-1];
        }

        return Arrays.stream(soredNumArray).sum();
    }
}
