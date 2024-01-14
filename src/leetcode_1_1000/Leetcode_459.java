package leetcode_1_1000;

public class Leetcode_459 {

    public static void main(String[] args) {
        Leetcode_459 leetcode459=new Leetcode_459();
        System.out.println(leetcode459.repeatedSubstringPattern("abcabcabcabc"));
    }


    public boolean repeatedSubstringPattern(String s) {

        // 这题可以使用KMP算法来解决，接下来我说下解题思路
        // kmp解法
        // 以abababab为例，我们要拿到最长相等前后缀下的其他子串，这个子串就是最小重复子串。为什么呢，往下推导
        // 我们能拿到最长相等前后缀的
        // 前缀 ababab
        // 后缀 ababab
        // 上面这两个肯定是相等的，不然咋叫最长相等前后缀，下面再写下，更清晰点
        // 字符串:abababab
        // 前缀:    ababab
        // 后缀         ababab
        //
        // 接下来我就开始描述位置了，比如前缀0就是这个字符串数组0位置的那个值
        // 因为前后缀相等，所以我们可以得出
        // 第一个周期:
        // 前缀0和前缀1等于后缀0和后缀1
        // 前缀0和前缀1等于前缀2和前缀3（这个看不懂，就看我上面那三个字符串）
        // 第二个周期:
        // 前缀2和前缀3等于后缀2和后缀3
        // 前缀2和前缀3等于前缀4和前缀5
        //
        // 发现了吗，这个周期，刚好是字符串减去相等前后缀得到的最小字符串
        // 这个是利用了最长相等的前后缀特性得来的，如果存在重复子串，那个一定是这个
        //
        //
        // 接下来解释下代码随想录的推导思路
        //
        // 假设字符串s使用多个重复子串构成（这个子串是最小重复单位），重复出现的子字符串长度是x，所以s是由n * x组成。
        // 解释:还是以abababab为字符串解释，这里重复出现的子串长度为2，所以x=2
        // s的长度是由n*x   例子中就是4*2
        //
        //
        // 因为字符串s的最长相同前后缀的长度一定是不包含s本身，所以 最长相同前后缀长度必然是m * x，而且 n - m = 1，（这里如果不懂，看上面的推理）
        //  我们知道例子中最长相等前后缀是ababab，长度为6
        // 那么m就是3  毕竟3*2为6。
        // n-m=1  而例子中就是4-3=1   这个1就是重复周期，明白了吗

        // 那么当字符串长度正好可以整除（字符串长度-最长相等前后缀长度=最小子串长度）时，说明当前这个字符串就是由重复子串组合而成的


        int length = s.length();

        // 获取前缀表
        int[] nextArray = getNextArray(s);



        if (nextArray[length-1]>0 && length%(length-nextArray[length-1])==0){
            return true;
        }



        return false;


    }

    /**
     * 获取字符串的前缀包
     * @param s
     */
    private int[] getNextArray(String s) {

        int length = s.length();
        char[] strCharArray = s.toCharArray();

        int[] nextArray=new int[s.length()];
        int prefixLocation=0;

        nextArray[0]=prefixLocation;


        // 循环字符串的所有子串，并拿到这些字符的相等前后缀长度
        for (int suffixLocation = 1; suffixLocation < length; suffixLocation++) {

            // 当前后缀不相等的时候就回退前缀位置
            while (prefixLocation>=1 && strCharArray[prefixLocation] != strCharArray[suffixLocation]){
                prefixLocation=nextArray[prefixLocation-1];
            }

            //若两个指针指向的位置相同，则前缀指针加一
            if (strCharArray[prefixLocation] == strCharArray[suffixLocation]) {
                prefixLocation++;
            }

            //将当前子串的最长相等前后缀写入到前缀表中
            nextArray[suffixLocation]=prefixLocation;
        }



        return nextArray;



    }

    private void moveMatch(String s) {
        // 这题可以使用移动匹配，这是一种定制化的办法
        // 假设这个s是一个由重复子串组合而成的话，那么一定能实现下面这个结构
        //
        //将s复制一份，复制的这个就是叫做s1吧，我将这两个字符串组合在一起
        // 得到了一个新的字符串，由s和s1组合而成，这个新的字符串就叫做ss1吧
        // 把这个ss1的首字母和尾字母去掉了，如果这个字符串内还能找到s，那就说明这个最开始的字符串s确实是由重复子串组合而成的
        // 你肯定会问为啥，那我举个例子吧，假设s字符串是"ababab"
        // 按照上面的流程，我们来一遍，复制ababab，这个就是s1，然后把他们两个字符串组合起来，得到了
        // ababab ababab ，我用空格分割下两个字符串，避免不好分辨，实际上是没有这个的啊
        // 然后我们去除首字母和尾字母，得到了 babab ababa,这个时候字符串是包含最开始的s的，所以这个最开始的字符串s是满足由重复子串组合而成的
        // 还看不懂，不管了，这就是一个定制化的需求，可以不理

    }


}
