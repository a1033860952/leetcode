package leetcode_1_1000;

/**
 * @author tianling
 * @description: 二叉搜索树中的搜索
 * @since 2024/3/1
 */
public class Leetcode_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }

        if (val>root.val){
            return searchBST(root.right,val);
        }else{
            return searchBST(root.left,val);
        }
    }

}
