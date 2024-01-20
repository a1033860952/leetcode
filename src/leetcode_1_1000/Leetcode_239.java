package leetcode_1_1000;

import java.util.*;

/**
 * @author tianling
 * @description:
 * @since 2024/1/20
 */
public class Leetcode_239 {

    public static void main(String[] args) {
        Leetcode_239 leetcode239=new Leetcode_239();

        System.out.println(Arrays.toString(leetcode239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        //阐述下思路，这题可以使用单调队列来实现，单调队列是一种要求队列中元素满足某种单调性（通常是递增或递减）
        // 具体的规则是不拘泥于形式的，只要满足上面这个要求我们都称为单调队列，而具体的规则我们就是要自己拟定了
        // 这题的话，我们是定义如下规则的，就是在push新元素的时候，排在元素之前的，且比元素小的，就把这元素杀掉
        // 然后再pop的时候，要判断pop的这个元素是不是当前最大的元素，是的话才pop元素，不然不就不pop
        // 比如 [1,3,-1,-3,5,3,6,7]为例，我们第一个滑动窗口的时候[1,3,-1] 队列里面会是[3,-1]
        // 然后到滑动到第二个窗口的时候，你总不能把3给pop出去吧，因为其实前面应该还有一个1的
        // 所以就有了下面这个规则，这样能避免错误弹出
        // 当要弹出元素时，且这个元素刚好是队头元素才弹出


        if (nums.length== 1){
            return nums;
        }

        int[] resultArray=new int[nums.length-k+1];
        int num=0;
        singleQueue singleQueue=new singleQueue();
        // 这一步其实就是第一个滑动窗口
        for (int i = 0; i < k; i++) {
            singleQueue.push(nums[i]);
        }

        // 设置第一个滑动窗口的最大值
        resultArray[num++]=singleQueue.getMaxValue();

        // 从第二个滑动窗口开始
        for (int i = k; i < nums.length; i++) {

            singleQueue.pop(nums[i-k]);

            singleQueue.push(nums[i]);

            // 获取滑动窗口的最大值
            resultArray[num++]=singleQueue.getMaxValue();

        }

        return resultArray;

    }

}


// 实现一个单调队列
class singleQueue{

    private Deque<Integer> queue;
    public singleQueue() {
        queue=new LinkedList<>();
    }

    public void pop(int val){
        // 比如 [1,3,-1,-3,5,3,6,7]为例，我们第一个滑动窗口的时候[1,3,-1] 队列里面会是[3,-1]
        //然后到滑动到第二个窗口的时候，你总不能把3pop出去吧，因为其实前面应该还有一个1的
        // 所以就有了下面这个规则，这样能避免错误弹出
        // 当要弹出元素时，且这个元素刚好是队头元素才弹出
        if (!queue.isEmpty() && val==queue.getLast()){
            queue.pollLast();
        }
    }


    public void push(int value) {
        while (!queue.isEmpty() && queue.getFirst() < value) {
            queue.removeFirst();
        }
        queue.push(value);
    }

    public int getMaxValue(){
        return queue.getLast();
    }




}

