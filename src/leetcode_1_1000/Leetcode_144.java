package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tianling
 * @description:
 * @since 2024/1/24
 */
public class Leetcode_144 {

    public static void main(String[] args) {
        Leetcode_144 leetcode144=new Leetcode_144();
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(leetcode144.preorderTraversal(treeNode));

    }



    public List<Integer> preorderTraversal(TreeNode root) {
        // 使用递归法来实现
        // List<Integer> resultList = recursionPreorderTraversal(root);


        // 使用迭代法来实现
        List<Integer> resultList= iterativeImplementation(root);


        return resultList;

    }

    /**
     * 迭代法实现先序遍历
     * @param root 根节点
     */
    private  List<Integer> iterativeImplementation(TreeNode root) {

        // https://www.cnblogs.com/MAKISE004/p/17073925.html
        // 迭代法其实就是使用栈去模拟递归的过程，所有的递归理论上都可以用迭代法来实现的
        // 我来解释下下面这段代码吧，下面有两个循环，一个是外循环，一个是内循环
        // 外循环的作用就是不停的往下走，内循环就是在外循环基础上往左右（并将当前节点放入结果集）
        // 这么说吧，外循环负责走根节点和右节点，然后内循环是以当前节点做根节点往左右



        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        // 当节点为空，且栈也是空的时候停止循环
        while (node!=null || !stack.isEmpty()){

            while (node!=null){
                //这一步其实就是将根节点写进去了
                resultList.add(node.val);
                stack.push(node);

                //这一段相当于先循环所有的左节点，一直往左走
                node= node.left;
            }

            //左边走完了，接下来就开始走右边了
            node=stack.pop();

            node=node.right;

        }


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
