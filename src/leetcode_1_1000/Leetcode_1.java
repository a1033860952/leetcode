package leetcode_1_1000;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1 {

    public int[] twoSum(int[] nums, int target) {
        // 这题其实可以用hash表去实现，题干说答案是a+b等于target，我们可以一个循环解决
        // 我们可以在遍历数组时，将值放入hash中，然后去hash中查找有没有这个值，比如：
        // 你拿到了a,然后用target-a就能拿到b,然后就可以去看看hahs中存在b吗，如果存在就可以返回了
        // 因为需要返回的是两个数的下标，所以我们需要用法map结构，key就是值，value就是值的下标

        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int otherNum = target - num;
            if (map.containsKey(otherNum)){
                Integer otherNumLocation = map.get(otherNum);
                return new int[]{i,otherNumLocation};
            }
            map.put(num,i);
        }






        return null;


    }
}
