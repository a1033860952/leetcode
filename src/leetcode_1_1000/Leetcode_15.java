package leetcode_1_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_15 {


    public static void main(String[] args) {
        Leetcode_15 leetcode15=new Leetcode_15();
        leetcode15.threeSum(new int[]{-2,0,0,2,2});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 题目的不能重复，首先是三个下标不能相同，并且不能有重复的三元组（即不能存在两个三元组 a=a1 b=b1 c=c1）
        // 这题可以用哈希表来解决，但是会非常麻烦，因为去重很麻烦

        // 所以最好使用双指针来解决和处理

        // 首先我们需要一个循环来定位三元组中的第一个元素，这个元素在循环内是一直不懂的
        // 然后然后左指针和右指针定位范围，若固定值+左右指针相加大于0，说明右指针范围大了，往左移动
        // 若小于0，说明左指针范围大了，左指针往右移动
        // 接下来我们就需要考虑去重方问题了，即两个三元组重复的问题，这个我们可以分为三个维度来解决，分别是a重复 b重复 c重复



        List<List<Integer>> resultList=new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {




            // 求的是a+b+c=0,在这里a已经固定了，所以我们需要求出b和c
            int fixValue=nums[i];
            int leftLocation=i+1;
            int rightLocation=nums.length-1;

            if (nums[i]>0){
                return resultList;
            }



            // 判断a是否重复,注意要想下面这样写，不然如果写成 nums[i+1]==nums[i] 可能会漏掉-1,-1,2 这种情况
            if (i>0 && nums[i-1]==nums[i]){
                continue;
            }

            while (leftLocation<rightLocation){
                int leftValue = nums[leftLocation];
                int rightValue = nums[rightLocation];

                if (fixValue+leftValue+rightValue==0){

                    ArrayList<Integer> tripletList = new ArrayList<>();
                    tripletList.add(fixValue);
                    tripletList.add(leftValue);
                    tripletList.add(rightValue);
                    resultList.add(tripletList);

                    // 判断b是否重复
                    while (leftLocation<rightLocation && nums[leftLocation+1]==nums[leftLocation]) {
                        leftLocation++;
                    }

                    // 判断c是否重复
                    while (leftLocation < rightLocation && nums[rightLocation - 1] == nums[rightLocation]) {
                        rightLocation--;
                    }


                    leftLocation++;
                    rightLocation--;

                }else if (fixValue+leftValue+rightValue>0){
                    rightLocation--;
                }else{
                    leftLocation++;
                }






            }

        }

        return resultList;
    }

}
