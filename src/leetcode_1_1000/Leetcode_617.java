package leetcode_1_1000;

/**
 * @author tianling
 * @description: 合并二叉树
 * @since 2024/3/1
 */
public class Leetcode_617 {


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // 其实下面这个还有可以优化的点，不用每次都new一个新的，可以直接在原有基础上改的


        TreeNode resultNode=null;
        if (root1==null && root2==null){
            return null;
        }


        if (root1!=null && root2!=null){
            resultNode=new TreeNode(root1.val+root2.val);
        }else if (root1!=null){
            resultNode=new TreeNode(root1.val);
        }else {
            resultNode=new TreeNode(root2.val);
        }

        resultNode.left=mergeTrees(root1==null?null:root1.left,root2==null?null:root2.left);
        resultNode.right=mergeTrees(root1==null?null:root1.right,root2==null?null:root2.right);


        return resultNode;


    }
}
