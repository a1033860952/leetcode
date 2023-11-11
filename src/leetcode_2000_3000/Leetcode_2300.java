package leetcode_2000_3000;

import java.util.Arrays;

public class Leetcode_2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //其实本质上就是求，这个咒语能和几个药水成功组合
        //由于答案是一个数组，代表这个spells能成功组合的药水有多少个，那么这个spells就不能动
        //我们可以寻找一个值，这个值是不能成功的最大的药水强度，这不就是最大中求最小吗，所以我们可以用二分法
        int[] answerArray= new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int value = dichotomy(spells[i], potions, success, 0, potions.length - 1);
            answerArray[i]=potions.length-(value+1);
//            System.out.println(value);
        }

        return answerArray;
    }

    private int dichotomy(int spell,int[] potions,long success,int left,int right){
        int mid= left+(right-left)/2;
        int result;

        if (left>right){
            //注意这一段，我们求的是最小中的最大，所有当左节点超过右节点时取right
            //相反如果我们求的是最大中的最小，那么我们返回是就是left了
            return right;
        }

        long value = (long)potions[mid] * spell;

        if (value>=success){
            result= dichotomy(spell,potions,success,left,mid-1);
        }else{
            result= dichotomy(spell,potions,success,mid+1,right);
        }

        return result;


    }
}
