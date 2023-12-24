package leetcode_1_1000;

import java.util.HashSet;

public class Leetcode_202 {


    public static void main(String[] args) {
        Leetcode_202 leetcode202=new Leetcode_202();
        leetcode202.isHappy(2);


    }

    public boolean isHappy(int n) {
        // 这题的重点是可能会出现无限循环的情况，是无限循环不是无限不循环
        // 所以一定会出现重复的数值，这个时候我们就可以使用哈希表去存储，看有没有出现重复的

        HashSet<Integer> set=new HashSet<>();

        while (n!=1 && !set.contains(n)){
            set.add(n);
            n=getNexValue(n);
        }

        return n==1;





    }

    private int getNexValue(int n) {
        String strN = String.valueOf(n);
        double value=0d;
        for (int i = 0; i < strN.length(); i++) {
            Double dChar = Double.valueOf(String.valueOf(strN.charAt(i)));
            value += dChar*dChar;
        }

        return (int) value;

    }

}
