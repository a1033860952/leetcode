package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/2/7
 */
public class Leetcode_404 {

    public static void main(String[] args) {


    }

    public int sumOfLeftLeaves(TreeNode root) {
        int result=0;

        // 返回所有左子树之和，使用先序遍历
        if (root==null){
            return 0;
        }

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;


        if (leftNode!=null){
            if (leftNode.left==null && leftNode.right==null){
                result+=leftNode.val;
            }
            result+=sumOfLeftLeaves(leftNode);
        }

        if (rightNode!=null){
            result+=sumOfLeftLeaves(rightNode);
        }


        return  result;
    }


}
