package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/1/24
 */
public class Leetcode_144 {

    public static void main(String[] args) {
        Leetcode_144 leetcode144=new Leetcode_144();
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(leetcode144.preorderTraversal(new TreeNode(1,null,null)));

    }



    public List<Integer> preorderTraversal(TreeNode root) {
        // 使用递归法来实现
        List<Integer> resultList = recursionPreorderTraversal(root);


        // 使用迭代法来实现



        return resultList;

    }

    /**
     * 递归法实现先序遍历
     * @param root 根节点
     * @return 遍历顺序
     */
    private List<Integer> recursionPreorderTraversal(TreeNode root) {
        List<Integer> resultList=new ArrayList<>();

        recursion(root,resultList);

        return resultList;
    }

    private void recursion(TreeNode node, List<Integer> resultList) {
        // 递归结束表示，避免死循环
        if (node==null){
            return;
        }

        //直接将当前节点放入集合中,并以当前节点为根节点，继续往下递归左右子树
        resultList.add(node.val);
        // 左子树遍历
        recursion(node.left,resultList);

        //右子树遍历
        recursion(node.right,resultList);
    }

}
