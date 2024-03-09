package other_topic;

import leetcode_1_1000.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tianling
 * @description:
 * @since 2024/3/8
 */
public class NodeUtil {


    /**
     * 根据层序遍历构建树结构
     * @param levelOrder 层序遍历数组
     * @return 树结构
     */
    public static TreeNode buildTreeFromLevelOrder(Integer[] levelOrder) {

        // 两种方式，一种直接计算节点位置，比如左子树是2i 右子树是2i+1  这样算
        // 还有一种是。。。。。。不知道




        if (levelOrder==null){
            return null;
        }

        if (levelOrder.length==1){
            return new TreeNode(levelOrder[0]);
        }


        return buildTreeAtLocation(levelOrder,0);


    }



    private static TreeNode  buildTreeAtLocation(Integer[] levelOrder,int startLocation){
        // 这个方法通过数组位置类构建二叉树，i从0开始，所以

        int length = levelOrder.length;
        if (startLocation>=length){
            return null;
        }
        if (levelOrder[startLocation]==null) {
            return null;
        }


        TreeNode rootNode = new TreeNode(levelOrder[startLocation]);

        rootNode.setLeft(buildTreeAtLocation(levelOrder,2*startLocation+1));
        rootNode.setRight(buildTreeAtLocation(levelOrder,2*startLocation+2));

        return rootNode;

    }

}
