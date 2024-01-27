package leetcode_1_1000;

import java.util.*;

/**
 * @author tianling
 * @description:
 * @since 2024/1/27
 */
public class Leetcode_107 {

    public static void main(String[] args) {
        Leetcode_107 leetcode107=new Leetcode_107();


        TreeNode leftNode=new TreeNode(9);
        TreeNode rightNode=new TreeNode(20,new TreeNode(15),new TreeNode(7));
        TreeNode mainNode=new TreeNode(3,leftNode,rightNode);


        System.out.println(leetcode107.levelOrderBottom(mainNode));

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        //层序遍历就需要用到队列了

        if (root==null){
            return Collections.emptyList();
        }
        TreeNode node=root;
        Queue<TreeNode> arrayQueue=new LinkedList<>();
        arrayQueue.add(root);
        int level;

        List<List<Integer>> resulList=new ArrayList<>();
        while (!arrayQueue.isEmpty()){
            level=arrayQueue.size();
            List<Integer> levelResultList=new ArrayList<>();
            while (level!=0){
                TreeNode pollNode = arrayQueue.poll();
                levelResultList.add(pollNode.val);
                if (pollNode.left!=null){
                    arrayQueue.add(pollNode.left);
                }

                if (pollNode.right!=null){
                    arrayQueue.add(pollNode.right);
                }
                level--;
            }
            resulList.add(levelResultList);

        }



        // 和层序遍历1的区别就是，这个结果要反转下
        Collections.reverse(resulList);
        return resulList;
    }


}
