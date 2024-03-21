package leetcode_1_1000;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/3/16
 */
public class Leetcode_90 {


    public static void main(String[] args) {

        Leetcode_90 leetcode90=new Leetcode_90();
        leetcode90.subsetsWithDup(new int[]{0});
    }



    private List<List<Integer>> resultList;

    private List<Integer> pathList;

    private  boolean[] isAccess;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        resultList=new LinkedList<>();
        pathList=new LinkedList<>();
        isAccess=new boolean[nums.length];

        Arrays.sort(nums);
        backTrack(nums,0);

        return resultList;


    }


    private void backTrack(int[] nums ,int startIndex){

        // 这题会出现重复的，所以可以用标识来确定值是否被使用了



        resultList.add(new LinkedList<>(pathList));

        // 这题有重复的
        for (int i = startIndex; i < nums.length; i++) {
            //isAccess[i-1] == true 说明同一层被使用过了，相当于是横向的遍历，如果是纵向的的遍历，不可能是i-1还是false的
            if (i>0 && nums[i]==nums[i-1] && !isAccess[i-1]){
                continue;
            }

            pathList.add(nums[i]);
            isAccess[i]=true;
            backTrack(nums,i+1);
            pathList.remove(pathList.size()-1);
            isAccess[i]=false;
        }
    }
}
