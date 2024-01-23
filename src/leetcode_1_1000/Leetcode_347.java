package leetcode_1_1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author tianling
 * @description:
 * @since 2024/1/20
 */
public class Leetcode_347 {
    public static void main(String[] args) {
        Leetcode_347 leetcode347=new Leetcode_347();

        System.out.println(Arrays.toString(leetcode347.topKFrequent(new int[]{1}, 1)));

    }



    public int[] topKFrequent(int[] nums, int k) {
        // 这题计算频率可以使用map来实现，重点在于如何给频率排序
        // 可以使用快排，但是在这题中我们求的是前k个元素，用快排有些浪费，毕竟快排是给所有数值都排序一遍的
        // 我们可以使用堆排，使用最小堆，题目说了可以按任意顺序返回答案，我们可以用最小堆来，让最小堆一直都只有k个元素
        // 当堆个数大于k时，就把最小的元素丢出去，这样到最后题目里留下的就是k个频率最高的元素了
        // 这种思想其实就是优先级队列

        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }


        // 队列元素为数组，0为元素本身，1为元素出现的次数
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size()<k){
                priorityQueue.add(new int[]{entry.getKey(),entry.getValue()});
            }else if(entry.getValue()>priorityQueue.peek()[1]){
                priorityQueue.poll();
                priorityQueue.add(new int[]{entry.getKey(),entry.getValue()});
            }
        }


        int[] result =new int[k];
        int i=0;
        for (int[] ints : priorityQueue) {
            result[i++]=ints[0];
        }
        return result;

    }











}
