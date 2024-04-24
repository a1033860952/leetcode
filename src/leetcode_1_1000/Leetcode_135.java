package leetcode_1_1000;

import java.util.Arrays;

/**
 * @author tianling
 * @description:
 * @since 2024/4/23
 */
public class Leetcode_135 {

    public static void main(String[] args) {
        Leetcode_135 leetcode135=new Leetcode_135();
        System.out.println(leetcode135.candy(new int[]{1,2,2}));
    }



    public int candy(int[] ratings) {

        // 这题要解决只能一边一边来，不能一个循环同时判定两边，不然会顾此失彼
        // 右孩子大于左孩子的情况（从前往后）  左孩子大于右孩子的情况（从后往前遍历）

        int[] candyArray =new int[ratings.length];
        Arrays.fill(candyArray,1);
        for (int i = 1; i < ratings.length; i++) {
            // 右孩子大于左孩子的情况
            if (ratings[i]>ratings[i-1]){
                candyArray[i]=candyArray[i-1]+1;
            }
        }


        // 从后往前遍历-左孩子大于右孩子的情况

        for (int i = ratings.length-1; i >0; i--) {
            //左孩子大于右孩子的情况

            int left = ratings[i - 1];
            int right = ratings[i];

            if (left> right){
                //这个时候我们这里要使用Math.max方法了，因为这个时候的candyArray已经存储着之前比较的右孩子大于左孩子的糖果数量
                //我们现在要按断做孩子大于右孩子的糖果数量，所以我们要在这两个上取一个最大值，这样才能前融左右两边的情况
                // 当前左孩子大于右孩子需要的糖果数量
                int currentNeedCandyCount=candyArray[i]+1;
                candyArray[i-1]=Math.max(candyArray[i]+1,candyArray[i-1]);

            }
        }

        return Arrays.stream(candyArray).sum();
    }

}
