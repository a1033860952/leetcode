package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/3/9
 */
public class Leetcode_669 {


    public TreeNode trimBST(TreeNode root, int low, int hight) {

        TreeNode virtureNode = new TreeNode();
        virtureNode.left = root;

        deleteNode(virtureNode, root, low,hight, true);
        return virtureNode.left;
    }


    public TreeNode deleteNode(TreeNode parentNode, TreeNode root, int low, int high, boolean isLeft) {
        if (root == null) {
            return null;
        }

        TreeNode resultNode = null;

        deleteNode(root, root.left, low, high, true);
        deleteNode(root, root.right, low, high, false);

        if (root.val < low || root.val > high) {
            if (root.left == null && root.right == null) {

            } else if (root.left != null && root.right != null) {
                //将根节点的左节点挂在右节点上
                TreeNode rightNode = root.right;
                while (rightNode.left != null) {
                    rightNode = rightNode.left;
                }
                rightNode.left = root.left;

                resultNode = root.right;
            } else if (root.left != null) {
                resultNode = root.left;
            } else {
                resultNode = root.right;
            }

            if (parentNode != null) {
                if (isLeft) {
                    parentNode.left = resultNode;
                } else {
                    parentNode.right = resultNode;
                }
            }

        }


        return parentNode;

    }


}
