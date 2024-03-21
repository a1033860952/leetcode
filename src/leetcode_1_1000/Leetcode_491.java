package leetcode_1_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/3/20
 */
public class Leetcode_491 {

    public static void main(String[] args) {
        Leetcode_491 leetcode491=new Leetcode_491();
        leetcode491.findSubsequences(new int[]{4,6,7,7});

    }


    private List<Integer> pathList;
    private List<List<Integer>> resultList;


    public List<List<Integer>> findSubsequences(int[] nums) {
        pathList=new LinkedList<>();
        resultList=new LinkedList<>();


        // 不能排序，因为题目求的是子序列，你排序后子序列就变了

        backTrack(nums,0);
        return resultList;

    }


    private void backTrack(int[] nums,int startIndex){

        // 这个是用来避免当前这一层取到重复的数值的
        List<Integer> accessList=new ArrayList<>();
        if (pathList.size()>=2){
            resultList.add(new LinkedList<>(pathList));
        }

        for (int i = startIndex; i < nums.length; i++) {
            // 当path中的最后一个元素大于当前的元素，说明这不是一个合格的子序列，直接放弃掉
            // 当集合中已经出现了重复元素，且同一层中已经用过这个元素了，那么为了避免重复就放弃掉当前
            if ((!pathList.isEmpty() && pathList.get(pathList.size() - 1) > nums[i]) || accessList.contains(nums[i])) {
                continue;
            }
            pathList.add(nums[i]);
            accessList.add(nums[i]);
            backTrack(nums,i+1);
            pathList.remove(pathList.size()-1);

        }
    }





}
