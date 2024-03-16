package leetcode_1_1000;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description: 分割回文串
 * @since 2024/3/13
 */
public class Leetcode_131 {

    public static void main(String[] args) {
        Leetcode_131 leetcode131=new Leetcode_131();
        leetcode131.partition("a");

    }




    private List<String> pathList;
    private List<List<String>> resultList;


    private StringBuilder stringBuilder;
    public List<List<String>> partition(String s) {
        pathList=new LinkedList<>();
        resultList=new LinkedList<>();
        stringBuilder=new StringBuilder();

        backTrack(s.length(),s,0);



        return resultList;
    }



    private void  backTrack(int length,String s,int startIndex){
        if (stringBuilder.toString().equals(s)){
            resultList.add(new LinkedList<>(pathList));
            return;
        }
        if (startIndex>=length){
            return;
        }

        for (int i = startIndex+1; i <= length; i++) {
            String subStr = s.substring(startIndex, i);
            if (isPalindrome(subStr)){
                pathList.add(subStr);
                stringBuilder.append(subStr);
                backTrack(length,s,i);
                pathList.remove(pathList.size()-1);
                int builderLength = stringBuilder.length();
                stringBuilder.delete(builderLength-subStr.length(),builderLength);

            }
        }
    }

    /**
     * 判断是否为回文字符串
     * @param s 字符串
     * @return
     */
    private boolean isPalindrome(String s){
        int length = s.length();
        if (length==1){
            return true;
        }

        int leftLocation=0;
        int rightLocation=s.length()-1;

        while (leftLocation<=rightLocation){
            if (s.charAt(leftLocation)!=s.charAt(rightLocation)) {
                return false;
            }
            leftLocation++;
            rightLocation--;
        }


        return true;
    }



}
