package leetcode_1_1000;

public class Leetcode_28 {

    public static void main(String[] args) {
        Leetcode_28 leetcode28=new Leetcode_28();
        leetcode28.strStr("leetcode","leeto");
    }

    public int strStr(String haystack, String needle) {
        //这题我们主要用KMP来实现，主要考察kmp算法


        if (needle.length()<1){
            return -1;
        }


        // 获取前缀表
        int[] nextArray = getNextArray(needle);


        //用于知道之前匹配了多少，当j的长度和模式串长度一致的时候就说明匹配上了
        int j=nextArray[0];
        // 遍历文本串
        for (int i = 0; i < haystack.length(); i++) {
            while (j>=1 && haystack.charAt(i)!=needle.charAt(j)){
                // 其实这一步就对应了前缀表的，如果你的前缀表形式有变化，那么这个也要有想要的修改
                j=nextArray[j-1];
            }

            // 当字符相等时，进一步匹配
            if (haystack.charAt(i)==needle.charAt(j)){
                j++;
            }

            // 当长度相等时，说明匹配成功了
            if (j==needle.length()){
                // 返回字符串中第一个匹配项的下标
                return i-needle.length()+1;
            }

        }

        return -1;
    }

    /**
     * 获取字符串的前缀表
     * @param str 字符串
     */
    private int[] getNextArray(String str) {
        // 前缀表
        int[] nextArray=new int[str.length()];

        // 首先要明白前缀表是怎么获取的，前缀表记录的是所有子串的最长相等的前缀和后缀的长度
        // 比如拿aabaaf举例吧，它的所有子串就有6个，分别是a,aa,aab,aaba,aabaa,aabaaf
        // 所以前缀表的长度就是6，值分别是a:0,aa:1,aab:0,aaba:1,aabaa:1,aabaaf:0
        // 以上就是这个方法要求的，如果不知道前缀和后缀的定义可以去看看思维导图

        // 一开始我们需要定义两个指针，一个指向前缀末尾的位置，一个指向后缀末尾的位置
        // 有些人一开始会将前缀指针定义为-1，其实是一样的，-1的话其实就是整体减一了
        // 我这里一开始就初始化为0了，这其实也是一种实现方式
        int prefixLocation=0;
        nextArray[0]=prefixLocation;

        // 这一步其实就是循环所有子串,同时也把把它当做后缀指针
        for (int suffixLocation = 1; suffixLocation < str.length(); suffixLocation++) {

            // 当不匹配的时候回退长度
            while (prefixLocation>=1 && str.charAt(prefixLocation)!=str.charAt(suffixLocation)){
                prefixLocation=nextArray[prefixLocation-1];
            }


            // 当前缀后缀都相等的时候，前缀加1
            if (str.charAt(prefixLocation)==str.charAt(suffixLocation)){
                prefixLocation++;
            }

            // 将当前子串的最长相等的前缀和后缀的长度写进前缀表
            nextArray[suffixLocation]=prefixLocation;


        }



        return nextArray;



    }

}
