package leetcode_1_1000;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tianling
 * @description:
 * @since 2024/4/24
 */
public class Leetcode_452 {


    public int findMinArrowShots(int[][] points) {
        // 这题也可以使用贪心算法来解决，解决思路如下
        // 首先我们肯定想一支箭射中多个，以此来达到最小射箭次数的问题，那么我们就需要知道哪些气球是相近的
        // 先排序下，根据位置0或者位置1都可以
        // 接下来就是判断气球的关联关系了，如何判断呢，就一句话，如下
        // 如果气球重叠了，重叠气球中右边边界的最小值 之前的区间一定需要一个弓箭
        // 按照上面这个规则，就能射出最少的弓箭,当然了，看上面的规则逻辑有点懵，那么我们看代码

        if (points.length==1){
            return 1;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int result=1;

        for (int i = 1; i < points.length; i++) {

            // 判断当前的气球是否和上一个气球重叠了

            if (points[i][0] >points[i-1][1]) {
                //当前的气球和上一个气球不关联，那么上一个气球和其关联的气球就需要一个箭头
                result++;
            }else{
                //当前的气球和上一个气球有重叠部分的，那就说明当前气球和上一个气球是可以用一支箭射爆的
                //所以直接略过往下走即可，但是这样就会有问题，因为当前气球和上一个气球有重叠部分，但是也可能和下一个气球有重叠部分
                //这样就会影响下一个气球的重叠判断，为了避免这个问题 ，我们可以把气球虚化一部分，这样下一个气球判断就不会有问题了
                // 虚化的规则是这样的，把两个气球的右边界都变成一样小的
                points[i][1]=Math.min(points[i-1][1],points[i][1]);
            }
        }
        return result;
    }

}
