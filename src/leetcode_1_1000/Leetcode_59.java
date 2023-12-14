package leetcode_1_1000;

import javax.xml.bind.ValidationEvent;

public class Leetcode_59 {

    public static void main(String[] args) {
        Leetcode_59 leetcode59 = new Leetcode_59();
        leetcode59.generateMatrix(1);
    }

    public int[][] generateMatrix(int n) {
        // 首先我们需要知道循环转几圈，这是一个正方形，边的长度为n，那么答案就是n/2
        // 为什么呢，你自己画图试试，每转一圈的时候，就会少两列，所以转几圈的答案就是这么得出来的
        // 如果n是奇数的话，那么转圈完成之后就会最中间应该还剩下一个格子，这个格子后面单独处理即可
        int circleCount=n/2;
        // 如果为奇数的话，那么
        int midLocation=circleCount;
        // 表示与边界的距离
        int offet=0;
        // 表示这是值，数组生成的值，后续会不断加1
        int value=0;
        int[][] resultArray=new int[n][n];

        while (circleCount-->0){
            // 所有循环都采用左闭右开原则

            // 从左到右那条边的循环
            for (int j = offet; j < n-1-offet; j++) {
                resultArray[offet][j]=++value;
            }

            // 从上到下那条边的循环
            for (int i = offet; i < n-1-offet; i++) {
                resultArray[i][n-1-offet]=++value;
            }

            //从右到左那条边的循环
            for (int j=n-1-offet;j>offet;j--){
                resultArray[n-1-offet][j]=++value;
            }

            //从下到上那条边
            for (int i =  n-1-offet; i > offet; i--) {
                resultArray[i][offet]=++value;
            }

            offet++;

        }

        if (n%2!=0){
            resultArray[midLocation][midLocation]=++value;
        }



        return resultArray;


    }
}
