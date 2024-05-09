package leetcode_1_1000;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tianling
 * @description:
 * @since 2024/4/29
 */
public class Leetcode_763 {
    public static void main(String[] args) {
        Leetcode_763 leetcode763=new Leetcode_763();
        leetcode763.partitionLabels("ababcbacadefegdehijhklij");

    }


    public List<Integer> partitionLabels(String S) {
        return partitionLabelsTwo(S);
    }


    /**
     * 解法1
     * @param S
     * @return
     */
    public List<Integer> partitionLabelsOne(String S) {
        // 这种解法是直接圈定最大范围，是一种很巧妙的写法，我们可以把同一个字母的最左边和最右边的范围试做一个区间
        // 而这个区间越长，说明这如果字母的最左边和左右边距离很大，那么至少在这个区间里的时候不能作为分割点
        // 根据题目来，分割点是需要从左到右的，且合起来还是原来的字符串，所以分割点也一定是从左到右的
        // 我们可以给每个字母加上一个标识索引，这个索引就是该字母的最右边位置索引
        // 如果只给了最右边索引,如何确定他的左边在那了.其实不用确定,我们有一个leftLocation索引，这个其实就是他的左边，然后使用right-left+1就能得到这个区间的长度
        // 而我们题目要求的就是区间的长度
        // 我们需要加一个当前的leftLocation和rightLocation
        // leftLocation的位置是用来判断当前数组走到了哪里，rightLocation是为了避免大区间中的小区间问题
        // leftLocation的值是跟着数组循环的索引走的，rightLocation是根据最大分割点的区间走的
        // 以上就是解法1的解题思路了


        // 一共就是26个字母
        int[] charCountArray=new int[27];

        int left=0;
        int right=0;

        List<Integer> resultList=new LinkedList<>();
        for (char c : S.toCharArray()) {
        }

        // 循环给所有字母设置上最右边索引
        for (int i = 0; i < S.length(); i++) {
            charCountArray[S.charAt(i)-'a']=i;
        }

        // 这里要循环字符串S，不能循环charCountArray，不然会出现空转现象
        for (int i = 0; i < S.length(); i++) {
            //更新right
            right=Math.max(right,charCountArray[S.charAt(i)-'a']);

            // 若相等，则说明已经到了此字母的最右边了
            if (i==right){
                resultList.add(right-left+1);
                left=right+1;
            }
        }

        return resultList;

    }


    /**
     * 解法2
     * @param S
     * @return
     */
    public List<Integer> partitionLabelsTwo(String S) {
        //解法2的思路如下，一开始将字母数组，根据每个字母的开始位置结束位置转换成一个map，然后再根据这个map去排序
        // 确定好了字母的区间后，就根据区间的开始位置或者结束位置去排序（先把一个维度确定下来）
        // 维度确定下来后，就可以判断区间是否重复了，若存在重复的说明此区间无法作为分割点
        // 如果没有重复的区间，说明这个区间可以作为一个重复的分割点
        // 以上就是解法2的解题思路

        Map<Character,int[]>  recordMap = new LinkedHashMap<>();
        // 确认好所有字母的开始位置和结束位置
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int[] intervalArray = recordMap.getOrDefault(c, new int[]{i,i});
            if (i>intervalArray[1]){
                intervalArray[1]=i;
            }
            recordMap.put(c,intervalArray);
        }

        int[][] soredArray = recordMap.values().stream().sorted((o1, o2) -> o1[0] - o2[0]).toArray(int[][]::new);

        List<Integer> resultList=new LinkedList<>();

        int left=0;
        int right=soredArray[0][1];

        for (int i = 1; i < soredArray.length; i++) {
            // 说明当前区间和之前的区间没有关联
            if (soredArray[i][0]>right){
                resultList.add(right-left+1);
                left=soredArray[i][0];
            }

            right=Math.max(right,soredArray[i][1]);
        }


        // 处理最右端数据,循环到最后还会有一个最右端的数据
        resultList.add(right - left + 1);

        return resultList;

    }


}
