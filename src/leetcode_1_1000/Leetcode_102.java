package leetcode_1_1000;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author tianling
 * @description:
 * @since 2024/1/27
 */
public class Leetcode_102 {


    public static void main(String[] args) {
        Leetcode_102 leetcode102=new Leetcode_102();

        TreeNode leftNode=new TreeNode(9);
        TreeNode rightNode=new TreeNode(20,new TreeNode(15),new TreeNode(7));
        TreeNode mainNode=new TreeNode(3,leftNode,rightNode);


        System.out.println(leetcode102.levelOrder(mainNode));

    }


    public List<List<Integer>> levelOrder(TreeNode root) {

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




        return resulList;

    }

}
