package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tianling
 * @description:
 * @since 2024/1/24
 */
public class Leetcode_94 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));

        Leetcode_94 leetcode94=new Leetcode_94();
        System.out.println(leetcode94.inorderTraversal(treeNode));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // return recursionInorderTraversal(root);

        return iterativeImplementation(root);
        
    }

    /**
     * 中序遍历的迭代实现
     * @param root
     */
    private List<Integer> iterativeImplementation(TreeNode root) {
        List<Integer> resultList=new ArrayList<>();
        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<>();
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.add(node);
                node=node.left;
            }

             node=stack.pop();
             resultList.add(node.val);
             node=node.right;

        }

        return resultList;

    }


    private List<Integer> recursionInorderTraversal(TreeNode root) {
        List<Integer> resultList=new ArrayList<>();

        recursion(root,resultList);

        return resultList;
    }

    /**
     * 中序遍历
     * @param node
     * @param resultList
     */
    private void recursion(TreeNode node, List<Integer> resultList) {
        // 递归结束表示，避免死循环
        if (node==null){
            return;
        }

        // 左子树遍历
        recursion(node.left,resultList);


        //将根节点放入集合
        resultList.add(node.val);

        //右子树遍历
        recursion(node.right,resultList);

    }
}
