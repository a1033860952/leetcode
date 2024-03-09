package leetcode_1_1000;

/**
 * @author tianling
 * @description: 二叉搜索树中的插入操作
 * @since 2024/3/9
 */
public class Leetcode_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 记住一点，这个是二叉树搜索树，不是平衡二叉树搜索树
        // 只需要保证二叉树有序，即左小右大 即可，根本不需要去改变什么书结构，题目又没有让我们优化平衡性，深度很深又咋样

        if (root==null){
            return new TreeNode(val);
        }

        if (val<root.val){
            if (root.left!=null) {
                insertIntoBST(root.left,val);
            }else{
                root.left=new TreeNode(val);
            }
        }

        if (val>root.val){
            if (root.right!=null) {
                insertIntoBST(root.right,val);
            }else{
                root.right=new TreeNode(val);
            }
        }

        return root;

    }

}
