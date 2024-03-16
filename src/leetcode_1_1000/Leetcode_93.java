package leetcode_1_1000;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tianling
 * @description:
 * @since 2024/3/15
 */
public class Leetcode_93 {


    public static void main(String[] args) {

        Leetcode_93 leetcode93=new Leetcode_93();
        leetcode93.restoreIpAddresses("101023");
    }


    private List<Integer> pathList;
    private List<String> resultList;

    private int countSum;
    public List<String> restoreIpAddresses(String s) {

        pathList=new LinkedList<>();
        resultList=new LinkedList<>();

        int length = s.length();
        if (length>16 || length<4){
            return resultList;
        }

        backTrack(s,0);
        return resultList;
    }


    private void backTrack(String s,int startIndex){
        if (pathList.size()>4){
            return;
        }
        if (countSum==s.length() && pathList.size()==4){
            StringBuilder stringBuilder=new StringBuilder();
            for (Integer valueInt : pathList) {
                stringBuilder.append(valueInt);
                stringBuilder.append(".");
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            resultList.add(stringBuilder.toString());
            return;
        }

        for (int i = startIndex+1; i <= Math.min(s.length(),startIndex+4) ; i++) {
            String subStr = s.substring(startIndex, i);
            if (subStr.startsWith("0") && subStr.length()>1){
                continue;
            }
            int valueInt = Integer.parseInt(subStr);
            if (valueInt>255){
                continue;
            }
                pathList.add(valueInt);
                countSum+=subStr.length();
                backTrack(s,i);
                pathList.remove(pathList.size()-1);
                countSum-=subStr.length();


        }


    }


}
