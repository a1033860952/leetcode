package leetcode_2000_3000;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode_2342 {
    public int maximumSum(int[] nums) {
        //这个问题是本质就是多个“位数和相同”的两个数加起来，求其中的最大值
        //位数和是位数相加，比如我356的位数和就是14，如果不存在位数和相同的，那么这个就肯定不在返回答案中了
        //这个相当于是由两层的，“不同位数和的最大”和"相同位数和的最大"  要先求第二个才能求第一个
        //相同位数和的最大等于 = 相同位数和的最大+相同位数和的次大,两个加起来就是相同位数和的最大值了(这里看不懂的去看题目的定义)
        //我们拿到多个相同位数和的最大的时候，再求最大值就把好了，然后返回即可
        //我们可以用空间换时间的办法，我们知道题目定义数组的值 最小为1，最大为10的9次方（十亿），也就是9位数（十亿不考虑，毕竟十亿加起来才为1）
        //最多为9位数，而位数最大也只是为9而已，那么就算你全是9我全加起来也才9*9=81 ，我们所以弄一个数组来存在每个位数和对于值的的最大和次大
        //保险点就100*2吧，反正也不在乎这点空间  看到这里应该知道怎么写了吧  开写

        //用于记录最大和次大   比如recordArray[x][0] 代表最大的  recordArray[x][1]代表次大
        int[][] recordArray=new int[100][2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digitSum = getDigitSum(num);
            int maxRecord = recordArray[digitSum][0];
            //先排序就是为了能让小的值在前面，可以先拿到次大的
            //由于可能存在相等的值，所以要大于等于
            if (num>=maxRecord){

                recordArray[digitSum][0]=num;
                recordArray[digitSum][1]=maxRecord;
            }
        }

        int result=-1;
        for (int i = 0; i < recordArray.length; i++) {
            int maxRecord = recordArray[i][0];
            int secondMaxRecord=recordArray[i][1];
            if (maxRecord==0 || secondMaxRecord==0){
                continue;
            }
            int value = maxRecord + secondMaxRecord;
            if (value>result){
                result=value;
            }
        }

        return result;

    }

    private int getDigitSum(int num) {
        int result=0;
        while (num>0){
            int digit = num % 10;
            result+=digit;
            num/=10;
        }
        return result;
    }
}
