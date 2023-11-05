package leetcode_1_1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        //这题挺简单的，就是遍历存储hash就好了

        Map<String,Integer> dnaStrMap=new HashMap<>();
        int length = s.length();
        List<String> resultList=new ArrayList<>();
        for (int i = 0; i <= length - 10; i++) {
            int j=i+10;
            String substring = s.substring(i, j);
            Integer count = dnaStrMap.get(substring);
            if (count==null) {
                count=0;
            }
            count++;
            if (count==2){
                resultList.add(substring);
            }
            dnaStrMap.put(substring,count);
        }

        return resultList;


    }
}
