package leetcode_1_1000;

import java.util.Arrays;

/**
 * @author tianling
 * @description:
 * @since 2024/3/9
 */
public class Leetcode_108 {


    public static void main(String[] args) {

        Leetcode_108 leetcode108=new Leetcode_108();
        TreeNode treeNode = leetcode108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        // 其实这个没必要写成copyOfRange的，直接传位置left 和right就好了



        if (nums==null || nums.length==0){
            return null;
        }

        int length = nums.length;
        if (length ==1){
            return new TreeNode(nums[0]);
        }


        int mid=length/2;

        TreeNode rootNode=new TreeNode(nums[mid]);

        rootNode.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));

        if (mid+1<=length){
            rootNode.right=sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,length));
        }


        return rootNode;

    }

}
