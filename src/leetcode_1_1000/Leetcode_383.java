package leetcode_1_1000;

public class Leetcode_383 {

    public static void main(String[] args) {
        Leetcode_383 leetcode383=new Leetcode_383();

        System.out.println(leetcode383.canConstruct("aa", "aab"));

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // 这题由于全是小写字母，且每个字母只能出现一次，
        // 所以我们可以使用数组来记录杂志中字母出现的次数，然后就使用的时候就剪掉1，
        // 当发现无法剪掉的时候，就说明字母不够用了

        char indexA='a';
        int[] charArray=new int[26];
        for (char c : magazine.toCharArray()) {
            charArray[c-indexA]++;
        }


        for (char c : ransomNote.toCharArray()) {
            charArray[c-indexA]--;
            if (charArray[c-indexA]<0) {
                return false;
            }
        }


        return true;

    }
}
