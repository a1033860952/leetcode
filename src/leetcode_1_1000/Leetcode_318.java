package leetcode_1_1000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_318 {

    public int maxProduct(String[] words) {

        //这题我们可以用位运算来解决，首先根据题目我们能知道，字符串中只会包含a-z，这24个小写字母
        //我们可以用一个24位的存储类型来存储这个字符串的，比如abcd,那么24位里，abcd这4个字母就存储1，其他的都存在0即可
        //确实会字符串超过24个字符的，但是无所谓，毕竟你字符串怎么变，都回收24个字符组合的，当字符很多的时候，肯定会存在重复字符的，重复字符无所谓嘛
        //我们用一个集合存储每个字符串对应的位运算结果集，然后想知道两个字符串是否有重合的，就将两个字符串对于的位运算结果集通过&运算符计算
        //&运算符是两真才为真，其余为假，所以只有当两个结果集&运算的结果为0时，才说明两个字符串没有重合字符


        int result=0;

        int[] maskArray=new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                //24个小写字母中，a最小，减掉a可以得到该字母距离a有多选，我们定义a为第零个
                int relationLocation = c - 'a';

                //将1左移相对位置，这就是该字符应该处于的位置
                int charMask = 1 << relationLocation;
                //如何组合字符起来呢，通过|（或）运算符组合
                mask |=charMask;
            }

            maskArray[i]=mask;
        }


        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((maskArray[i]&maskArray[j]) == 0){
                    result= Math.max(result,words[i].length() * words[j].length());
                }
            }
        }


        return result;
    }
}
