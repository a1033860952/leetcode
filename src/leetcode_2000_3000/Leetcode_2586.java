package leetcode_2000_3000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_2586 {

    public int vowelStrings(String[] words, int left, int right) {
        int result=0;
        Character[] characters=new Character[]{'a','e','i','o','u'};
        List<Character> characterList=new ArrayList<>(Arrays.asList(characters));
        for (int i = left; i <= right; i++) {
            String str = words[i];
            char firstChar = str.charAt(0);
            char secondChar = str.charAt(str.length() - 1);
            if (characterList.contains(firstChar) && characterList.contains(secondChar)){
                result++;
            }
        }

        return result;
    }


}
