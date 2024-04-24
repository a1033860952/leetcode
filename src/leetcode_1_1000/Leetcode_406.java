package leetcode_1_1000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author tianling
 * @description:
 * @since 2024/4/24
 */
public class Leetcode_406 {


    public static void main(String[] args) {
        Leetcode_406 leetcode406=new Leetcode_406();
        int[][] ints = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        leetcode406.reconstructQueue(ints);
    }

    public int[][] reconstructQueue(int[][] people) {
        // 像这种两个维度的，我们需要一个个来，先解决第一个维度，再取解决第二个维度
        // 别想着全解决掉，会顾此失彼的
        // 这题的话，我们可以先根据身高这个一个维度排序，先确定好身高再处理第二个维度
        // 至于为什么不先处理第二个维度，因为这样处理的话，会发现两个维度，那个都没确定好

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 若身高相同，则前面人少的排前面
                if (a[0]==b[0]) {
                    // a - b 是升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
                    return a[1]-b[1];
                }
                //b - a 是降序排列，在a[0] != b[0]，的狀況會根據h值降序排列
                return b[0]-a[0];
            }
        });


        // 用一个队列来存储
        LinkedList<int[]> queue=new LinkedList<>();

        for (int[] person : people) {
            queue.add(person[1],person);
        }





        return queue.toArray(new int[][]{});

    }


}
