package leetcode_1_1000;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/3/12
 */
public class Leetcode_39 {


    public static void main(String[] args) {
        Leetcode_39 leetcode39=new Leetcode_39();
        leetcode39.combinationSum(new int[]{2,3,6,7},7);
    }

    private int[] candidates;

    private List<List<Integer>> resultList;

    private List<Integer> pathList;
    private int sum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.candidates=candidates;
        resultList=new LinkedList<>();
        pathList=new LinkedList<>();
        sum=0;
        Arrays.sort(candidates);

        backTrack(target,0);

        return resultList;

    }


    private void backTrack(int target,int startIndex){
        if (sum==target){
            resultList.add(new LinkedList<>(pathList));
        }
        if (sum>target){
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum+=candidates[i];
            pathList.add(candidates[i]);
            backTrack(target,i);
            sum-=candidates[i];
            pathList.remove(pathList.size()-1);
        }


    }

}
