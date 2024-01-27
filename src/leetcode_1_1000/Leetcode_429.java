package leetcode_1_1000;

import java.util.*;

/**
 * @author tianling
 * @description:
 * @since 2024/1/27
 */
public class Leetcode_429 {


    public List<List<Integer>> levelOrder(Node root) {

        //层序遍历就需要用到队列了

        if (root==null){
            return Collections.emptyList();
        }
        Node node=root;
        Queue<Node> arrayQueue=new LinkedList<>();
        arrayQueue.add(root);
        int level;

        List<List<Integer>> resulList=new ArrayList<>();
        while (!arrayQueue.isEmpty()){
            level=arrayQueue.size();
            List<Integer> levelResultList=new ArrayList<>();
            while (level!=0){
                Node pollNode = arrayQueue.poll();
                levelResultList.add(pollNode.val);
                arrayQueue.addAll(pollNode.children);
                level--;
            }
            resulList.add(levelResultList);

        }




        return resulList;

    }
}
