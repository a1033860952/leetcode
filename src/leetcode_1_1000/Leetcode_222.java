package leetcode_1_1000;

/**
 * @author tianling
 * @description:
 * @since 2024/2/2
 */
public class Leetcode_222 {
    public static void main(String[] args) {
        TreeNode secondNode=new TreeNode(2,new TreeNode(4),new TreeNode(5));
        TreeNode second2Node=new TreeNode(3,new TreeNode(6),null);
        TreeNode mainNode=new TreeNode(1,secondNode,second2Node);



        Leetcode_222 leetcode222=new Leetcode_222();
        System.out.println(leetcode222.countNodes(mainNode));


    }


    public int countNodes(TreeNode root) {
        //这题我们可以使用前中后 层序遍历来实现，这样的话复杂度是ON
        //我们可以再优化下，题干说了，给的树肯定是一个完全二叉树，那么我们可以使用二叉树的性质
        // 我们可以去判断下，树或者其中子树是否为满二叉树，如果是满二叉树的，我们可以直接使用公式去计算

        // 下面是代码随想录的描述
        // 完全二叉树只有两种情况，情况一：就是满二叉树，情况二：最后一层叶子节点没有满。
        //
        // 对于情况一，可以直接用 2^树深度 - 1 来计算，注意这里根节点深度为1。
        //
        // 对于情况二，分别递归左孩子，和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树，然后依然可以按照情况1来计算。


        if (root==null){
            return 0;
        }

        // 获取左子树的深度,这里从0开始是为了下面公式求指数方便
        int leftNodeDepth=0;
        int rightNodeDepth=0;
        TreeNode leftNode=root.left;
        TreeNode rightNode=root.right;

        while (leftNode!=null){
            leftNode=leftNode.left;
            leftNodeDepth++;
        }

        while (rightNode!=null){
            rightNode=rightNode.right;
            rightNodeDepth++;
        }


        // 当两个相等时，说明自当前节点往下的是满二叉树
        if (leftNodeDepth==rightNodeDepth){
            // 这个公式下的深度是从0开始的
            return (2<<leftNodeDepth)-1;
        }

        int leftCount = countNodes(root.left);

        int rightCount = countNodes(root.right);

        return leftCount+rightCount+1;

    }


}
