package leetcode_1_1000;

import java.util.*;

/**
 * @author tianling
 * @description:
 * @since 2024/1/27
 */
public class Leetcode_199 {

    public List<Integer> rightSideView(TreeNode root) {
        // 吐槽下，神经病一样的描述，这题其实就是拿到每一层的最右节点


        if (root==null){
            return Collections.emptyList();
        }
        List<Integer> resultList=new ArrayList<>();


        List<List<Integer>> leveOrderList = levelOrder(root);
        for (List<Integer> leveList : leveOrderList) {
            resultList.add(leveList.get(leveList.size()-1));
        }


        return resultList;

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
