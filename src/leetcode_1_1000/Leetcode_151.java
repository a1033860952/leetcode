package leetcode_1_1000;

public class Leetcode_151 {
    public static void main(String[] args) {
        Leetcode_151 leetcode151 =new Leetcode_151();
        System.out.println(leetcode151.reverseWords("  hello world  "));


    }


    public String reverseWords(String s) {
        // 由于java的String是不可变的，所以不需要要用新空间的，不能在原有空间上处理
        // 這一題我们可以用StringBuilder来实现,其实总共就分三步
        // 1、移除前后中间多余的空格 2.反转整个字符串 3.单独反转单词字符串


        // 移除前后中间多余空格
        StringBuilder stringBuilder = removeExcessiveBlankSpace(s);
        // 反转字符串
        reverseStr(stringBuilder,0,stringBuilder.length()-1);
        // 单独反转单词字符串
        reverseWord(stringBuilder);


        return stringBuilder.toString();

    }

    private void reverseWord(StringBuilder stringBuilder) {
        // 设置初始值
        int startLocation=0;
        int endLocation=1;
        int length = stringBuilder.length();

        // 循环找空格，分割出每个单词
        while (startLocation< length){

            // 循环增加end
            while (endLocation<length && stringBuilder.charAt(endLocation)!=' '){
                endLocation++;
            }

            // 这样写可以避免最后一个字符没有反转
            reverseStr(stringBuilder,startLocation,endLocation-1);
            startLocation=endLocation+1;
            endLocation=startLocation+1;
        }

    }

    private void reverseStr(StringBuilder stringBuilder,int startLocation,int endLocation) {
        // 使用双指针指向两端，并互相交换即可

        while (startLocation<endLocation){

            char startChar = stringBuilder.charAt(startLocation);
            char endChar = stringBuilder.charAt(endLocation);
            stringBuilder.setCharAt(startLocation,endChar);
            stringBuilder.setCharAt(endLocation, startChar);
            startLocation++;
            endLocation--;
        }

    }

    private StringBuilder removeExcessiveBlankSpace(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        int startLocation=0;
        int endLocation=s.length()-1;


        // 首先将首尾的空格都去除掉
        while (s.charAt(startLocation)==' '){
            startLocation++;
        }
        while (s.charAt(endLocation)==' '){
            endLocation--;
        }

        while (startLocation<=endLocation){
            char c = s.charAt(startLocation);

            // 判断当前字符是否为空格，若是空格则再判断是否为单词间的合理空格
            // 其实就是判断上一个stringBuilder的最后一个字符是不是空格
            if (c!=' ' || stringBuilder.charAt(stringBuilder.length()-1)!=' '){
                stringBuilder.append(c);
            }
            startLocation++;
        }

        return stringBuilder;
    }



}
