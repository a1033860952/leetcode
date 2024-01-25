package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tianling
 * @description:
 * @since 2024/1/24
 */
public class Leetcode_145 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        Leetcode_145 leetcode145=new Leetcode_145();
        System.out.println(leetcode145.postorderTraversal(treeNode));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // 遍历写法
        // return recursionPostorderTraversal(root);

        // 迭代写法
        return iterativeImplementation(root);

    }

    /**
     * 迭代实现后序遍历
     * @param root
     * @return
     */
    private  List<Integer> iterativeImplementation(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        // 用于走到右节点时，右节点的主节点不会丢失
        TreeNode last = null;

        while (node!=null || !stack.isEmpty()){

            while (node!=null){
                stack.add(node);
                node=node.left;
            }

            node=stack.pop();
            if (node.right==null || node.right==last){
                resultList.add(node.val);
                //记录当前访问过的节点
                last=node;
                node=null;
            }else{
                stack.add(node);
                node=node.right;
            }

        }

        return resultList;



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
