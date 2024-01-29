package leetcode_1_1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tianling
 * @description:
 * @since 2024/1/29
 */
public class Leetcode_101 {

    public static void main(String[] args) {
        TreeNode secondLeftNode=new TreeNode(2,new TreeNode(3),new TreeNode(4));
        TreeNode secondRightNode=new TreeNode(2,new TreeNode(4),new TreeNode(3));
        TreeNode mainNode=new TreeNode(1,secondLeftNode,secondRightNode);
        Leetcode_101 leetcode101=new Leetcode_101();
        System.out.println(leetcode101.isSymmetric(mainNode));
    }

    public boolean isSymmetric(TreeNode root) {
        // 这题可以使用迭代或者递归来解决，这里我们使用迭代来解决
        // 递归的话其实就写一个compare（leftNode,rightNode）去实现，在这里就不多赘述了
        // 迭代的话其实就是使用队列把这一层的节点都放进去，然后判断最左边和最右边是否一致

        if (root==null){
            return true;
        }

        Queue<TreeNode> queue=new LinkedList<>();

        // 获取头结点的左右节点
        TreeNode rootLeft=root.left;
        TreeNode rootRight=root.right;


        queue.add(rootLeft);
        queue.add(rootRight);

        while (!queue.isEmpty()){
            // 这里拿出来的其实会是当前队列里树的最左孩子和最右孩子
            rootLeft=queue.poll();
            rootRight=queue.poll();


            if (rootLeft==null && rootRight==null){
                continue;
            }

            if (rootLeft == null){
                return false;
            }

            if (rootRight == null){
                return false;
            }

            if (rootLeft.val != rootRight.val){
                return false;
            }

            //到这一步的时候说明上面两个节点是轴心对称的，接下来把他们的孩子放进去
            // 这样放进去的话，当循环取出两个节点的时候就刚好是需要比较是否轴心对称的两个节点
            queue.add(rootLeft.left);
            queue.add(rootRight.right);
            queue.add(rootLeft.right);
            queue.add(rootRight.left);

        }


        return true;



    }


}
