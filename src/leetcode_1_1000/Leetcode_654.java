package leetcode_1_1000;

import java.util.Arrays;

/**
 * @author tianling
 * @description:
 * @since 2024/2/28
 */
public class Leetcode_654 {

    public static void main(String[] args) {
        Leetcode_654 leetcode654=new Leetcode_654();
        TreeNode treeNode = leetcode654.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode);


    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 最大二叉树，感觉左右递归下去就好了

        if (nums.length==1){
            return new TreeNode(nums[0]);
        }

        // 先找到最大的
        int maxLocation=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>nums[maxLocation]){
                maxLocation=i;
            }
        }

        TreeNode rootNode=new TreeNode(nums[maxLocation]);

        if (maxLocation!=0){
            rootNode.left=constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxLocation));
        }

        if (maxLocation+1 != nums.length){
            rootNode.right=constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxLocation+1,nums.length));;
        }



        return rootNode;

    }


}
