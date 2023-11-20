package leetcode_1_1000;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode_704 {


    public int search(int[] nums, int target) {

        Arrays.sort(nums);
        //我这里使用的是左闭右闭区间的写法
        return halfSearch(nums,0,nums.length-1,target);
        

    }

    private int halfSearch(int[] nums, int left,int right,int target){

        if (left<=right){
            int mid=left +((right-left)/2);
            int midValue = nums[mid];
            if (nums[mid]==target){
                return mid;
            }
            //说明在右边
            if (target>midValue){
                return halfSearch(nums,mid+1,right,target);
            }else{
                //说明在左边
                return halfSearch(nums,left,mid-1,target);
            }


        }

        return -1;

    }


}
