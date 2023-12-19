package leetcode_1_1000;

import java.util.Arrays;

public class Leetcode_242 {

    public static void main(String[] args) {
        Leetcode_242 leetcode242=new Leetcode_242();
        leetcode242.isAnagram("rat","car");

    }

    public boolean isAnagram(String s, String t) {
        // 这题我们可以使用数组来存储，都是小写字母，我们根据a-z的ASCII的相对循序来存储即可
        // 就是弄一个长度为26的条码，a是0，以此类推就就可以了

        char relateIndex='a';
        int[] letterArray=new int[26];

        Arrays.fill(letterArray,0);

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            letterArray[letter-relateIndex]=letterArray[letter-relateIndex]+1;
        }


        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            letterArray[letter-relateIndex]=letterArray[letter-relateIndex]-1;
        }


        for (int i = 0; i < letterArray.length; i++) {
            int letter = letterArray[i];
            if (letter!=0){
                return false;
            }
        }
        return true;

    }

}
