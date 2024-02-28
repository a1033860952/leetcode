package leetcode_1_1000;

import java.util.Arrays;
import java.util.Spliterator;

/**
 * @author tianling
 * @description:
 * @since 2024/2/9
 */
public class Leetcode_106 {

    public static void main(String[] args) {
        Leetcode_106 leetcode106=new Leetcode_106();
        TreeNode treeNode = leetcode106.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }


    /**
     * 从中序与后序遍历序列构造二叉树
     * @param inorder 中序遍历数组
     * @param postorder 后序遍历数组
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 这题其实挺简单的，我们可以用下面步骤来一个个分解
        // 首先获取根节点，后序遍历中的最后一个节点肯定是根节点了
        // 然后拿到根节点的在中序遍历中的位置，左边的就是左子树了，右边的就是右子树了
        // 知道原理后，我们就可以递归往下了，递归的参数就是切割出来的
        // 这里我们统一使用左闭右开原则


        // 重点在于递归往下的时候如何切割中序数组和后序数组
        // 中序简单，根据节点左右切割即可，后序的话，麻烦一点
        // 我们首先需要明确，中序数组长度和后序数组长度肯定是一样的
        // 又因为后序数组的遍历循序是左右中，所以，我们拿到了中节点所在后序数组中的位置，就能得到左右节点了
        // 至于左右节点如何分开，可以根据中序数组来区别，之前我们不是拆分了中序数组吗，这样就能得到左子树是多少个元素，右子树是多少个元素
        // 然后这样就能把后序数组彻底给拆分开了


        if (inorder.length==0){
            return null;
        }



        // 获取root节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode treeNode =new TreeNode(rootValue);



        // 拆分中序数组
        int i =0;
        for (i = 0; i < inorder.length; i++) {
            //找到中序所在位置
            if (inorder[i]==rootValue){
                break;
            }
        }
        // 中序左数组
        int[] leftInorder = new int[0];
        if (i+1<=inorder.length){
            leftInorder = Arrays.copyOfRange(inorder, 0, i);
        }
        // 中序右数组
        int[] rightInorder = new int[0];
        if (i+1<inorder.length){
           rightInorder = Arrays.copyOfRange(inorder, i+1,inorder.length);
        }

        // 拆分后序数组，拆分时不包括最后一个，因为最后一个是当前的root节点

        // 拆分后序左数组
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);

        // 拆分后序右数组
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftPostorder.length, leftPostorder.length+rightInorder.length);



        treeNode.left=buildTree(leftInorder,leftPostorder);

        treeNode.right=buildTree(rightInorder,rightPostorder);


        return treeNode;

    }


}
