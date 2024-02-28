package leetcode_1_1000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tianling
 * @description:
 * @since 2024/2/9
 */
public class Leetcode_112 {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        boolean leftResult=false;
        if (root.left!=null){
            leftResult = hasPathSum(root.left, targetSum - root.val);
        }


        boolean rightResult=false;
        if (root.right!=null){
            rightResult = hasPathSum(root.right, targetSum - root.val);
        }

        // 说明到叶子节点了
        if (root.left==null && root.right==null){
            if (root.val==targetSum){
                return true;
            }
        }

        return leftResult||rightResult;

    }
}
