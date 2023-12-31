package leetcode_1_1000;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_454 {

    public static void main(String[] args) {
        Leetcode_454 leetcode454=new Leetcode_454();
        leetcode454.fourSumCount(new int[]{0},new int[]{0},new int[]{0},new int[]{0});





    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 这题我们可以使用map来解决，，第一个map的key为a+b的值，value为次数
        // 第二个map的key为c+d的值，value为出现的次数
        // 已知我们需要求的是a+b+c+d=0 ,所以我们拿到a+b的值的时候就知道我们要拿到的c+b值是多少了
        // 最后再累加起来即可得到答案


        // 写完后的其他感悟，其实第二个map是没有必要的
        // 因为完全可以在计算b+c的map，就计算result值，根本没有必要第二个map

        Map<Integer,Integer> mapOne=new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int key=i+j;
                mapOne.put(key,mapOne.getOrDefault(key,0)+1);
            }
        }

        Map<Integer,Integer> mapTwo=new HashMap<>();
        for (int i : nums3) {
            for (int j : nums4) {
                int key=i+j;
                mapTwo.put(key,mapTwo.getOrDefault(key,0)+1);
            }
        }



        int value=0;
        for (Integer ab : mapOne.keySet()) {
            Integer abCount = mapOne.get(ab);
            Integer cdCount = mapTwo.get(-ab);
            if (cdCount==null){
                continue;
            }
            value+=abCount*cdCount;

        }

        return value;





    }

}
