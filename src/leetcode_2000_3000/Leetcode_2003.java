package leetcode_2000_3000;

import java.util.*;

public class Leetcode_2003 {

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {

        //首先明确一点 nums[i] 互不相同，也就是说基因值1只会存在一个地方
        //这题没有说是二叉树，也就是说可能会有很多个分支
        //其实我们不需要太关注其他分支，我们只需要找到一个从根节点到1的那条分支线，只有经过的节点才有计算基因值的必要
        //因为那条线有最小值1，所以这条线上的节点可能是其他值。 而其他线上的节点只会是1，不可能是其他情况的

        //明确了上面这条概念后，我们就需要知道如何计算那条特殊线上的值了，首先我们需要一个数组，来存储每个节点的子序列
        //上层节点的子序列必然保证下层节点的子序列，所以一个局部主节点的子序列就是（"左子树的子序列"+"右子树的子序列"+"本身的值"）
        //我们知道了那条特殊线，那么我们会从线底忘上遍历，在这个过程中我们需要用标识Set不断记下被遍历的节点



        int length = nums.length;
        int[] answer=new int[length];

        Arrays.fill(answer,1);


        //寻找到起点，也就是基因值为1的位置
        int startLocation=-1;
        for (int i = 0; i < length; i++) {
             if (nums[i]==1){
                startLocation=i;
             }
        }

        //如果不存在基因值为1的位置，那就简单了，答案直接就全是1;
        if (startLocation<0){
            return answer;
        }


//        List<Integer>[] subsequenceArray=new ArrayList[length];
        //建立一个集合数组，用于存储子序列
        ArrayList<Integer>[] subsequenceArray=new ArrayList[length];
        Arrays.setAll(subsequenceArray,e->new ArrayList<>());

        //从1开始，因为0的父节点是-1
        for (int i = 1; i < length; i++) {
            //注意这一段，这一段相当于存储了每个父节点下的子节点有哪些
            subsequenceArray[parents[i]].add(i);
        }


        //标识set，用于知道某个节点是否已经遍历过了，若存在说明遍历过了
        Set<Integer> identifySet=new HashSet<>();

        int nodeLocation=startLocation;

        //默认为2，因为你找到的这个唯一线已经有1了，所以默认值不可能是2
        int genevalue=2;
        //当遍历当最高的根结点时，就结束了，再往前就不处理了
        while (nodeLocation>=0){
            dfs(nodeLocation,subsequenceArray,identifySet,nums);
            //判断当前节点的基因值是多少
            while (identifySet.contains(genevalue)){
                genevalue++;
            }
            answer[nodeLocation]=genevalue;
            nodeLocation=parents[nodeLocation];
        }
        return answer;

    }


    //
    private void dfs(int mainNodeLocation,List<Integer>[] subsequenceArray,Set<Integer> identifySet,int[] nums){
        //标记当前节点已经遍历了
        identifySet.add(nums[mainNodeLocation]);
        for (Integer sonNodeLocation : subsequenceArray[mainNodeLocation]) {
            //获取当前节点
            int numValue = nums[sonNodeLocation];
            // 如果当前节点没有被遍历到，就继续往下遍历
            if (!identifySet.contains(numValue)){
                dfs(sonNodeLocation,subsequenceArray,identifySet,nums);
            }
        }

    }
}
