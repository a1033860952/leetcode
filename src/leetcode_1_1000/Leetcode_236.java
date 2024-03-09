package leetcode_1_1000;

import other_topic.NodeUtil;

/**
 * @author tianling
 * @description:
 * @since 2024/3/8
 */
public class Leetcode_236 {
    public static void main(String[] args) {
        TreeNode root = NodeUtil.buildTreeFromLevelOrder(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});

        Leetcode_236 leetcode236=new Leetcode_236();
        TreeNode treeNode = leetcode236.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(treeNode.getVal());


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 像这种题我们一般都是自下而上得到的，但是二叉树我们只能从上往下遍历
        // 但是我们可以使用后序遍历啊，因为后序遍历尽管也是从上往下的，但是处理逻辑时是从下往上的，毕竟左右中嘛
        // 所以我们可以利用后序遍历的逻辑来处理

        // 整理流程是这样的，处理时，判断左右子树是否遇到了p和q，如果遇到了则返回
        // 若左右节点都返回了node，说明当前的的根节点就是最近公共祖先，
        // 还有一种可能就是p就是q的父节点，那这样的话就只需要返回p即可，
        // 因为无所谓，到最后无限往上的时候，发现没有只有一个节点，那个可能就是我上面说的这样情况了（毕竟题目说了p和q一定存在）



        if (root==null){
            return null;
        }

        if (root.val==p.val || root.val == q.val){
            return root;
        }


        TreeNode leftNodeResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNodeResult = lowestCommonAncestor(root.right, p, q);

        if (leftNodeResult!=null && rightNodeResult!=null){
            return root;
        }

        if (leftNodeResult!=null){
            return leftNodeResult;
        }

        if (rightNodeResult!=null){
            return rightNodeResult;
        }


        return null;
    }
}
