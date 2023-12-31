package leetcode_1_1000;

import java.util.List;

public class Leetcode_15 {


    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 题目的不能重复，首先是三个下标不能相同，并且不能有重复的三元组（即不能存在两个三元组 a=a1 b=b1 c=c1）
        // 这题可以用哈希表来解决，但是会非常麻烦，因为去重很麻烦

        // 所以最好使用双指针来解决和处理

        // 首先我们需要一个循环来定位三元组中的第一个元素，这个元素在循环内是一直不懂的
        // 然后然后左指针和右指针定位范围，若固定值+左右指针相加大于0，说明右指针范围大了，往左移动
        // 若小于0，说明左指针范围大了，左指针往右移动










        return null;

    }

}
