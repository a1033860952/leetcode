package leetcode_1_1000;

import java.util.Arrays;

public class Leetcode_541 {
    public static void main(String[] args) {
        Leetcode_541 leetcode541=new Leetcode_541();
        System.out.println(leetcode541.reverseStr("abcd",2));
    }


    public String reverseStr(String s, int k) {


        int length = s.length();

        char[] charArray = s.toCharArray();

        int i = 2*k;
        for (; i < length; i+=(2*k)) {
            reverseString(i-(2*k),i-(2*k)+k,charArray);
        }

        int remaining = length - (i-(2*k));
        if (remaining>0){
            if (remaining>k){
                reverseString(length-remaining,length-remaining+k,charArray);
            }else{
                reverseString(length-remaining,length,charArray);
            }
        }

        return new String(charArray);

    }

    public void reverseString(int startLocation,int endLocation, char[] s) {
        int leftLocation=startLocation;
        int rightLocation=endLocation-1;

        while (leftLocation<rightLocation){
            char tmp = s[leftLocation];
            s[leftLocation]=s[rightLocation];
            s[rightLocation]=tmp;

            leftLocation++;
            rightLocation--;

        }
    }


}
