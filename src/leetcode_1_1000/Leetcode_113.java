package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/2/9
 */
public class Leetcode_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> totalResultList=new ArrayList<>();
        if (root==null){
            return totalResultList;
        }

        if (root.left==null && root.right==null && root.val==targetSum){
            ArrayList<Integer> resultList = new ArrayList<>();
            resultList.add(root.val);
            totalResultList.add(resultList);
            return totalResultList;
        }


        hasPathSum(root,targetSum,totalResultList,new ArrayList<>());

        return totalResultList;
    }

    public boolean hasPathSum(TreeNode root, int targetSum,List<List<Integer>> totalResultList,List<Integer> resultList) {

        if (root==null){
            return false;
        }

        resultList.add(root.val);

        boolean leftResult;
        if (root.left!=null){
            leftResult = hasPathSum(root.left, targetSum - root.val,totalResultList,resultList);
            if (leftResult){
                totalResultList.add(new ArrayList<>(resultList));
            }
            resultList.remove(resultList.size()-1);

        }


        boolean rightResult;
        if (root.right!=null){
            rightResult = hasPathSum(root.right, targetSum - root.val,totalResultList,resultList);
            if (rightResult){
                totalResultList.add(new ArrayList<>(resultList));
            }
            resultList.remove(resultList.size()-1);

        }

        // 说明到叶子节点了
        if (root.left==null && root.right==null){
            return root.val == targetSum;
        }

        return false;

    }

}
