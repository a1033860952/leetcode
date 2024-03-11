package leetcode_1_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/3/10
 */
public class Leetcode_77 {

    public static void main(String[] args) {
        Leetcode_77 leetcode77=new Leetcode_77();
        leetcode77.combine(4,2);
    }


    private List<Integer> pathList;
    private List<List<Integer>> resultList;

    public List<List<Integer>> combine(int n, int k) {

        //  这题可以使用回溯算法来解决，不太好描述，代码中领会把

        // 下面这个是回溯模板
        // void backtracking(参数) {
        //     if (终止条件) {
        //         存放结果;
        //         return;
        //     }
        //
        //     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        //         处理节点;
        //         backtracking(路径，选择列表); // 递归
        //         回溯，撤销处理结果
        //     }
        // }

        pathList= new LinkedList<>();
        resultList=new LinkedList<>();

        backtracking(n,k,1);

        return resultList;


    }

    /**
     *
     * @param n 数值范围
     * @param k 每个答案的个数
     * @param startIndex 开始位置，避免出现重复组合，题外话：要注意组合和排列的区别
     */
    private void backtracking(int n,int k ,int startIndex){
        // 说明当前组合已经满足了答案需要的个数
        if (pathList.size()==k){
            resultList.add(new ArrayList<>(pathList));
            return;
        }

        for (int i = startIndex; i <= n-(k-pathList.size())+1; i++) {
            pathList.add(i);
            backtracking(n,k,i+1);
            pathList.remove(pathList.size()-1);
        }
    }
}
