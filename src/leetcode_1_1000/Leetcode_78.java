package leetcode_1_1000;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/3/16
 */
public class Leetcode_78  {

    public static void main(String[] args) {
        Leetcode_78 leetcode78=new Leetcode_78();
        leetcode78.subsets(new int[]{0});

    }



    private List<List<Integer>> resultList;

    private List<Integer> pathList;
    public List<List<Integer>> subsets(int[] nums) {
        resultList=new LinkedList<>();
        pathList=new LinkedList<>();


        backTrack(nums,0);

        return resultList;


    }


    private void backTrack(int[] nums ,int startIndex){
        resultList.add(new LinkedList<>(pathList));

        for (int i = startIndex; i < nums.length; i++) {
            pathList.add(nums[i]);
            backTrack(nums,i+1);
            pathList.remove(pathList.size()-1);
        }
    }

}
