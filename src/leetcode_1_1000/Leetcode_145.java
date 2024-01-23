package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/1/24
 */
public class Leetcode_145 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        Leetcode_145 leetcode145=new Leetcode_145();
        System.out.println(leetcode145.recursionPostorderTraversal(treeNode));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // 遍历写法
        return recursionPostorderTraversal(root);

    }


    private List<Integer> recursionPostorderTraversal(TreeNode root) {
        List<Integer> resultList=new ArrayList<>();

        recursion(root,resultList);

        return resultList;
    }

    private void recursion(TreeNode node, List<Integer> resultList) {
        // 递归结束表示，避免死循环
        if (node==null){
            return;
        }

        // 左子树遍历
        recursion(node.left,resultList);

        //右子树遍历
        recursion(node.right,resultList);

        //将根节点放入集合
        resultList.add(node.val);
    }

}
