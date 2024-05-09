package leetcode_1_1000;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;
import other_topic.MyArrayUtil;
import other_topic.StringUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/5/8
 */
public class Leetcode_56 {

    public static void main(String[] args) {

        Leetcode_56 leetcode56=new Leetcode_56();
        leetcode56.merge(MyArrayUtil.stringTo2DArray("[[1,3],[2,6],[8,10],[15,18]]"));

    }


    public int[][] merge(int[][] intervals) {
        // 这题我们可以先确定一个维度，排好序，然后再确认重叠就可以了

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        List<int[]> resultList=new LinkedList<>();


        int left=intervals[0][0];
        int right=intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // 这个要注意的是到最后一个i了，不管是进入到了if判断还是没进入到
            // 这个i对应区间的数据都不会进去的result中的，所以我们要在后面再额外处理下


            if (right>= intervals[i][0]){
                right=Math.max(intervals[i][1],right);
                continue;
            }
            resultList.add(new int[]{left,right});
            left=intervals[i][0];
            right=intervals[i][1];
        }

        // 处理最后的数据
        resultList.add(new int[]{left,right});





        int[][] resultArray = resultList.stream().toArray(int[][]::new);






        return resultArray;

    }


}
