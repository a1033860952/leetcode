package leetcode_1_1000;

public class Leetcode_209 {

    public static void main(String[] args) {
        Leetcode_209 leetcode209 = new Leetcode_209();
        System.out.println(leetcode209.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));

    }

    public int minSubArrayLen(int target, int[] nums) {
        //这题就使用滑动窗口即可，窗口内容就是数组内容
        //如何移动窗口的起始位置：当窗口内容的数组加起来超过nums.length的时候就往前滑动
        //如何移动窗口的结束位置：for循环下移动即可
        //我们需要的是最长子数组的长度，所以我们需要一个result变量来存储这个最长长度

        //一开始假设这个数组无限大
        int result=Integer.MAX_VALUE;
        int windowStartIndex=0;
        int windowsEndIndex=0;
        int length = nums.length;
        //用于计算窗口内的值
        int windowsValue=0;
        for (int i = 0; i < length; i++) {
            windowsValue+=nums[i];
            //当数组里值大于长度时，滑动窗口就要收缩了
            while (windowsValue>=target){
                //拿到当前合格的子序列
                int subSequent=windowsEndIndex-windowStartIndex+1;
                result= Math.min(subSequent, result);
                windowsValue-=nums[windowStartIndex++];

            }
            windowsEndIndex++;


        }
        return result==Integer.MAX_VALUE?0:result;



    }


}
