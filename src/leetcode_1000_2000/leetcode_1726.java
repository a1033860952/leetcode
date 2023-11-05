package leetcode_1000_2000;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1726 {

    //首先假设我们已经得到了一组答案（a*b=c*d），此答案是可以变化成8种不同的，可以自己试一试，

    //继续往下推导，满足题目要求的是两边值一样，那我们假设值是m,即m=a*b=c*d

    //系统了我们一组nums，里面可能不止m=a*b=c*d,还有可能是m=a*b=c*d*e*f

    //我们就可以循环把nums数组里面的两两相乘得到的结果存在起来，并看看有多少个
    //我们可以用一个map，key呢就是相乘得到的结果，而value是由多少个相乘得到的结果是这个的个数

    //然后我们就得到看最多的那个乘积相同的个数，接下来就是组合排序了

    //假设得到的是a,b,c 三个乘积个数  那么两个两个组合得到排列组合是多少呢 a = b , a = c , c=b ,然和3个又有8种变化，所以最后的答案是3*8=24

    //假设得到的是a,b,c.d 4个乘积个数  那么两个两个组合得到排列组合是多少呢 a = b , a = c , a=d , b=c ,b=d ,c =d  ,然和6个又有不同的个数，所以最后的答案是6*8=32
    /**
     * 然后如何得公式呢，注意看  刚开始以a为主的能得到3个 （a=b,a=c,a=d）
     * 然后到b为主 ，因为之前已经有了a=b  所以只能有2两个  即 (b=c ,c=d)
     * 再然后到c  因为之前已经有了a=c，b =c 了所以只有一个 c =d
     * d的话是完全没机会了  ，3 ， 2， 1 ，0是完全递减的
     * 是不是可以得到（4-1）+（4-2）+（4-3）+（4-4）=6  再进一步我们可以把4-4移掉  因为没有意义毕竟都是0
     * 可以得到（4-1）+（4-2）+（4-3）=6 ，现在看是不是有3个4了  我们可以把3个4先乘起来，比如 （3*4），然后是被剪掉的数，加起来是1+2+3=6
     * 发现了吗，（3*4）=12，而1+2+3=6  刚好是倍数关系，接下来我们就可以得到公式了，假设cnt是乘积个数，可以得到公式
     * cnt*(cnt-1)/2  这就是公式，然后之前知道是8种不同变化，那么  完整的公式就是cnt*(cnt-1)/2*8
     *
     *
     */

    public static int tupleSameProduct(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> resultMap =new HashMap<>();
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                resultMap.put(key,resultMap.get(key)==null? 1 :resultMap.get(key)+1);
            }

        }

        Integer realCount=0;
        for (Integer value : resultMap.values()) {
            if (value>=2){
                realCount+= value*(value-1)/2*8;
            }

        }

        if (realCount==0){
            return 0;
        }

        return realCount;
    }

}
