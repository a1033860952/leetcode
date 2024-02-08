package leetcode_1_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/2/3
 */
public class Leetcode_257 {

    public static void main(String[] args) {
        TreeNode mainNode=new TreeNode(1,new TreeNode(2,null,new TreeNode(5)),new TreeNode(3));


        Leetcode_257 leetcode257=new Leetcode_257();
        System.out.println(leetcode257.binaryTreePaths(mainNode));


    }


    public List<String> binaryTreePaths(TreeNode root) {
        //这题可以使用先序遍历来实现

        List<String> resultList=new ArrayList<>();
        preorder(root,new ArrayList<>(),resultList);



        return resultList;


    }

    /**
     * 先序遍历，计算所有可达路径
     * @param node 递归起始节点
     * @param routeList 路径集合（后续需要根据这个知道当前叶子节点通过了哪些）
     * @param resultList 结果集合
     */
    private void preorder(TreeNode node,List<Integer> routeList,List<String> resultList){
        if (node==null){
            return;
        }
        routeList.add(node.val);
        //当左右子树都为空的时间，说明到了叶子节点了
        if (node.left==null && node.right==null){
            StringBuilder stringBuilder=new StringBuilder();
            int zeroRoute = routeList.get(0);
            stringBuilder.append(zeroRoute);
            for (int i = 1; i < routeList.size(); i++) {
                stringBuilder.append("->");
                stringBuilder.append(routeList.get(i));
            }
            resultList.add(stringBuilder.toString());
        }

        if (node.left!=null){
            preorder(node.left,routeList,resultList);
            //这一步其实就是回溯的时候去掉上一个递归加的数据，避免路径集合中出现错误数据
            routeList.remove(routeList.size()-1);
        }

        if (node.right!=null){
            preorder(node.right,routeList,resultList);
            //这一步其实就是回溯的时候去掉上一个递归加的数据，避免路径集合中出现错误数据
            routeList.remove(routeList.size()-1);
        }

    }

}
