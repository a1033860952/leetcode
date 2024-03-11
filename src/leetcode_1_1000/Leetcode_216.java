package leetcode_1_1000;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/3/11
 */
public class Leetcode_216 {

    public static void main(String[] args) {
        Leetcode_216 leetcode216=new Leetcode_216();
        leetcode216.combinationSum3(3,9);
    }

    private List<Integer> pathList;
    private List<List<Integer>> resultList;
    // 记录当前路径的总数
    private int sum;
    public List<List<Integer>> combinationSum3(int k, int n) {

        pathList=new LinkedList<>();
        resultList=new LinkedList<>();
        sum=0;
        backtrack(k,n,1);

        return resultList;

    }

    private void backtrack(int k,int n,int startIndex){
        if (sum==n && pathList.size()==k){
            resultList.add(new LinkedList<>(pathList));
            return;
        }

        if (sum>n){
            return;
        }


        // 如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
        for (int i = startIndex; i <= 9 - (k - pathList.size()) + 1; i++) {
            pathList.add(i);
            sum+=i;
            backtrack(k,n,i+1);
            pathList.remove(pathList.size()-1);
            sum-=i;
        }


    }


    private int countCurrentPathValue(){
        return pathList.stream().mapToInt(Integer::intValue).sum();
    }


}
