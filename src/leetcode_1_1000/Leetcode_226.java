package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/1/29
 */
public class Leetcode_226 {

    public static void main(String[] args) {

    }


    public TreeNode invertTree(TreeNode root) {
        //思路就是先序遍历，然后翻转每个节点的左右子树
        recursion(root);

        return root;
    }

    private void recursion(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode tmpNode=root.left;
        root.left=root.right;
        root.right=tmpNode;
        recursion(root.left);
        recursion(root.right);

    }

}
