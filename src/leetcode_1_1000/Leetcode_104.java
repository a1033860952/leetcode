package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/1/31
 */
public class Leetcode_104 {

    public int maxDepth(TreeNode root) {
        //一般我们求二叉树的高度都是使用后序遍历，而求深度一般都是使用先序遍历
        //但是这题的话是求二叉树的最大深度，而二叉树根节点的高度其实就是二叉树的最大深度
        //所以我们可以使用后序遍历来求二叉树根节点的高度来解决这个问题

        return recursion(root);

    }

    private int recursion(TreeNode root) {
        if (root==null){
            return 0;
        }

        return Math.max(recursion(root.left),recursion((root.right)))+1;


    }

}
