package leetcode_1_1000;

import other_topic.NodeUtil;

/**
 * @author tianling
 * @description: 删除二叉搜索树中的节点
 * @since 2024/3/9
 */
public class Leetcode_450 {

    public static void main(String[] args) {
        TreeNode rootNode = NodeUtil.buildTreeFromLevelOrder(new Integer[]{5,3,6,2,4,null,7});

        Leetcode_450 leetcode450=new Leetcode_450();
        leetcode450.deleteNode(rootNode,3);


    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // 写得有点乱，逻辑全都是自己想的


        TreeNode virtureNode=new TreeNode();
        virtureNode.left=root;

        deleteNode(virtureNode,root,key,true);
        return virtureNode.left;
    }


    public TreeNode deleteNode(TreeNode parentNode,TreeNode root,int key,boolean isLeft){
        if (root==null){
            return null;
        }

        TreeNode resultNode=null;

        if (root.val!=key){
            deleteNode(root,root.left,key,true);
            deleteNode(root,root.right,key,false);
        }else{


            if (root.left==null && root.right==null){

            }else if(root.left!=null && root.right!=null){
                //将根节点的左节点挂在右节点上
                TreeNode rightNode=root.right;
                while (rightNode.left!=null){
                    rightNode=rightNode.left;
                }
                rightNode.left=root.left;

                resultNode=root.right;
            }else if (root.left!=null){
                resultNode=root.left;
            }else{
                resultNode=root.right;
            }

            if (parentNode!=null){
                if (isLeft){
                    parentNode.left=resultNode;
                }else{
                    parentNode.right=resultNode;
                }
            }

        }



        return parentNode;

    }

}
