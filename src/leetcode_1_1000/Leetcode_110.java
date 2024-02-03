package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/2/3
 */
public class Leetcode_110 {
    public static void main(String[] args) {
        Leetcode_110 leetcode110=new Leetcode_110();
        TreeNode leftNode=new TreeNode(2,new TreeNode(3,new TreeNode(4),null),null);
        TreeNode rightNode=new TreeNode(2,null,new TreeNode(3,null,new TreeNode(4,null,null)));

        TreeNode mainNode=new TreeNode(1,leftNode,rightNode);

        System.out.println(leetcode110.isBalanced(mainNode));

    }


    public boolean isBalanced(TreeNode root) {
        // 这题没啥好说的，直接后续遍历
        if (root==null){
            return true;
        }


        int leftBalancedDepth = getBalancedDepth(root.left);
        int rightBalancedDepth = getBalancedDepth(root.right);

        if (leftBalancedDepth==Integer.MAX_VALUE ||rightBalancedDepth ==Integer.MAX_VALUE ){
            return false;
        }

        if (Math.abs(leftBalancedDepth-rightBalancedDepth)>1){
            return false;
        }


        return true;

    }

    private int getBalancedDepth(TreeNode node) {
        if (node==null){
            return 0;
        }

        int leftBalancedDepth = getBalancedDepth(node.left);
        int rightBalancedDepth = getBalancedDepth(node.right);

        if (leftBalancedDepth==Integer.MAX_VALUE ||rightBalancedDepth ==Integer.MAX_VALUE ){
            return  Integer.MAX_VALUE;
        }

        if (Math.abs(leftBalancedDepth-rightBalancedDepth)>1){
            return Integer.MAX_VALUE;
        }


        return Math.max(leftBalancedDepth,rightBalancedDepth)+1;

    }

}
