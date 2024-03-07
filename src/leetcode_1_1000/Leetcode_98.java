package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianling
 * @description: 验证二叉搜索树
 * @since 2024/3/1
 */
public class Leetcode_98 {

    public boolean isValidBST(TreeNode root) {

        // 对于二叉搜索树而言，中序遍历得到的应该就是一个有序的值，若得到的不是有序的，那就说明不是一个正常的二叉搜索树


        // 中序遍历
        List<Integer> nodeList=new ArrayList<>();

        center(root,nodeList);

        int size = nodeList.size();
        if (size==1){
            return true;
        }

        for (int i = 1; i < size; i++) {
            if (nodeList.get(i-1)>=nodeList.get(i)) {
                return false;
            }

        }

        return true;
    }

    // 中序遍历
    private void center(TreeNode root, List<Integer> nodeList) {
        if (root==null){
            return;
        }

        //左
        center(root.left,nodeList);
        //中
        nodeList.add(root.val);
        //右
        center(root.right,nodeList);

    }


    /**
     * 这是写的时候犯的一个错误，只比较了局部，未处理全局问题
     * @param root
     * @return
     */
    public boolean isValidBSTError(TreeNode root) {

        if (root==null){
            return true;
        }

        if (root.left==null && root.right==null){
            return true;
        }

        boolean leftValidate = root.left==null ||  (root.left.val < root.val);
        boolean rightValidate = root.right == null || (root.right.val > root.val);
        if (!leftValidate || !rightValidate){
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);

    }


}
