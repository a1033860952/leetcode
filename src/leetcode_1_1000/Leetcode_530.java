package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/3/6
 */
public class Leetcode_530 {

    public int getMinimumDifference(TreeNode root) {

        List<Integer> inOrderList=new ArrayList<>();
        inOrder(root,inOrderList);
        int result=Integer.MAX_VALUE;


        for (int i = 1; i < inOrderList.size(); i++) {
            int value = inOrderList.get(i) - inOrderList.get(i - 1);
            if (value<result){
                result=value;
            }
        }

        return result;

        // 其实可以继续优化，没有必要得到集合后再计算，在中序遍历的时候就可以了

    }


    /**
     * 中序遍历
     * @param root
     * @param inOrderList
     */
    private void inOrder(TreeNode root, List<Integer> inOrderList) {
        if (root==null){
            return;
        }

        inOrder(root.left,inOrderList);
        inOrderList.add(root.val);
        inOrder(root.right,inOrderList);


    }


}
