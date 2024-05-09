package leetcode_1_1000;

import other_topic.MyArrayUtil;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tianling
 * @description:
 * @since 2024/4/28
 */
public class Leetcode_435 {

    public static void main(String[] args) {
        Leetcode_435 leetcode435=new Leetcode_435();
        int[][] array={{1,2},{2,3},{3,4},{1,3}};
        leetcode435.eraseOverlapIntervals(MyArrayUtil.stringTo2DArray("[[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]"));
    }


    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]){
                return a[1]-b[1];
            }

            return a[0]-b[0];
        });

        int result=0;
        for (int i = 1; i < intervals.length; i++) {
            //发现当前区间的左边界小于前一个区间的右边界，则说明这两个区间有重叠部分
            if (intervals[i][0]<intervals[i-1][1]){
                result++;
                intervals[i][1]=Math.min(intervals[i][1],intervals[i-1][1]);
            }
        }

        return result;
    }


}
