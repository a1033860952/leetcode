package leetcode_1_1000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/3/12
 */
public class Leetcode_17 {

    public static void main(String[] args) {

        Leetcode_17 leetcode17=new Leetcode_17();
        leetcode17.letterCombinations("");

    }


    private char[] charArray;
    private List<Character> pathList;
    private List<String> resultList;
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        charArray = digits.toCharArray();
        pathList=new LinkedList<>();
        resultList=new LinkedList<>();

        backTrack(length,0);

        return resultList;
    }


    private void backTrack(int length,int index){

        // pathList可以使用StringBuilder的来的，删除可以使用deleteCharAt


        if (pathList.size()==length){
            if (length==0){
                return;
            }
            resultList.add(String.join("",pathList.stream().map(Object::toString).toArray(String[]::new)));
            return;
        }

        for (char c : getDigitCharList(charArray[index])) {
            pathList.add(c);
            backTrack(length,index+1);
            pathList.remove(pathList.size()-1);
        }

    }


    private char[] getDigitCharList(char c){

        if (c=='2'){
            return new char[]{'a','b','c'};
        }else if (c=='3'){
            return new char[]{'d','e','f'};
        }else if (c=='4'){
            return new char[]{'g','h','i'};
        }else if (c=='5'){
            return new char[]{'j','k','l'};
        }else if (c=='6'){
            return new char[]{'m','n','o'};
        }else if (c=='7'){
            return new char[]{'p','q','r','s'};
        }else if (c=='8'){
            return new char[]{'t','u','v'};
        }else  if (c=='9'){
            return new char[]{'w','x','y','z'};
        }else{
            return new char[]{};
        }


    }
}
