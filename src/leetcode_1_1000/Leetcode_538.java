package leetcode_1_1000;

import other_topic.NodeUtil;

/**
 * @author tianling
 * @description:
 * @since 2024/3/10
 */
public class Leetcode_538 {

    public static void main(String[] args) {

        TreeNode root = NodeUtil.buildTreeFromLevelOrder(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        Leetcode_538 leetcode538=new Leetcode_538();
        TreeNode treeNode = leetcode538.bstToGst(root);
        System.out.println(treeNode);


    }



    private int preValue=0;
    public TreeNode bstToGst(TreeNode root) {

        // 请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
        // 题目还说明了这是一个二叉树，那么我们就知道了，我们只需要累加父节点数据，根节点右边的数据，自己右边的数据即可
        // 那是不是可以这样遍历总结数据，右根左，其实就是反中序遍历


        if (root==null){
            return null;
        }

        int val=0;


        // 右
        bstToGst(root.right);

        // 上
        // 本质上，这个其实就是父节点对吧，所以我们需要累加，一开始最右边的时候肯定0嘛
        // 然后到当前位置的时候，如果父节点存在，那个这个节点的值应该是自己+右边全部的值
        preValue+=root.val;
        val+= preValue;
        root.val=val;

        // 左
        bstToGst(root.left);




        return root;

    }
}
