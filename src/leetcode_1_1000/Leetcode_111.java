package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/1/31
 */
public class Leetcode_111 {


    public int minDepth(TreeNode root) {
        // 首先这题是使用最小深度（根节点到叶子节点的最小深度），一般我们求深度都是使用先序遍历
        // 但是呢这题求的是最小深度，而最小深度的值其实如果反过来看恰好等于最小高度（根节点到叶子节点的最小高度）
        // 所以我们可以用后序遍历来求最小高度，要是要注意要到叶子节点才算
        // 描述得可能有点不清晰，反正大概这意思。



        // 使用后序遍历来递归循环


        if (root==null){
            return 0;
        }

        int leftValue = minDepth(root.left);

        int rightValue = minDepth(root.right);



        // 这一步说明当前节点还不是完全的叶子节点
        if (root.left!=null && root.right==null){
            return 1+leftValue;
        }

        if (root.right!=null && root.left==null){
            return 1+rightValue;
        }


        return 1+Math.min(leftValue,rightValue);


    }

}
