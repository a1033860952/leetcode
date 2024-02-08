package leetcode_1_1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tianling
 * @description:
 * @since 2024/2/7
 */
public class Leetcode_513 {

    public int findBottomLeftValue(TreeNode root) {
        // 找出给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值

        if (root==null){
            return 0;
        }

        Queue<TreeNode> queue =new LinkedList<TreeNode>();
        queue.add(root);

        int result=0;
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode==null){
                    break;
                }

                if (i==0){
                    // 这样循环下去，最后一层的最左边就是结果
                    result=treeNode.val;
                }

                if (treeNode.left!=null){
                    queue.add(treeNode.left);
                }

                if (treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
        }

        return result;

    }


}
