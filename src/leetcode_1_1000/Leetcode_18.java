package leetcode_1_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_18 {
    public static void main(String[] args) {

        Leetcode_18 leetcode18=new Leetcode_18();
        leetcode18.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296);

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 这题其实就是在三数之和的基础上迭代的，固定的前两个字符，然后再加上左右指针

        List<List<Integer>> resultList=new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            // 判断a是否重复
            if (i>0 && nums[i-1]==nums[i]){
                continue;
            }

            for (int j=i+1;j< nums.length;j++){

                // 判断b是否重复
                if (j>i+1 && nums[j-1]==nums[j]){
                    continue;
                }

                // 求的是a+b+c+d=0,在这里a和b已经固定了，所以我们需要求出c和d
                int fixOneValue=nums[i];
                int fixTwoValue=nums[j];
                int leftLocation=j+1;
                int rightLocation=nums.length-1;


                while (leftLocation<rightLocation){
                    int leftValue = nums[leftLocation];
                    int rightValue = nums[rightLocation];

                    long sum = (long)fixOneValue+fixTwoValue + leftValue + rightValue;

                    if (sum==target){

                        ArrayList<Integer> tripletList = new ArrayList<>();
                        tripletList.add(fixOneValue);
                        tripletList.add(fixTwoValue);
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

                    }else if (sum >target){
                        rightLocation--;
                    }else{
                        leftLocation++;
                    }






                }
            }



        }

        return resultList;



    }
}
