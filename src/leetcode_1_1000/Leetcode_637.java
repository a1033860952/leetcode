package leetcode_1_1000;

import java.util.*;

/**
 * @author tianling
 * @description:
 * @since 2024/1/27
 */
public class Leetcode_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resultList=new ArrayList<>();

        List<List<Integer>> levelOrderList = levelOrder(root);
        for (List<Integer> levelOrder : levelOrderList) {
            double sum = levelOrder.stream().mapToDouble(Integer::intValue).sum();
            resultList.add(sum/levelOrder.size());
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
