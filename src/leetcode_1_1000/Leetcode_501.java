package leetcode_1_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tianling
 * @description: 二叉搜索树中的众数
 * @since 2024/3/6
 */
public class Leetcode_501 {

    private List<Integer> resultList=new ArrayList<>();

    private int count;

    private int maxCount;

    // 用于记录上一个节点
    private TreeNode preNode;

    public int[] findMode(TreeNode root) {
        //这题可以通过二叉树的性质来解题


        maxCount=0;

        count=0;

        preNode=null;

        inOrder(root);

        return resultList.stream().mapToInt(Integer::intValue).toArray();





    }

    private void inOrder(TreeNode node) {
        if (node==null){
            return;
        }

        // 左
        inOrder(node.left);

        // 说明是根节点
        if (preNode==null){
            count=1;
        }else if (preNode.val==node.val){
            count++;
        }else{
            count=1;
        }

        preNode=node;


        if (count==maxCount){
            resultList.add(node.val);
        }

        if (count>maxCount){
            maxCount=count;
            resultList.clear();
            resultList.add(node.val);
        }

        inOrder(node.right);

    }
}
