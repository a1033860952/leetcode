package leetcode_2000_3000;

public class Leetcode_2698 {

    public int punishmentNumber(int n) {
        //首先这题我需要循环n，循环值我们假设为i，现在的问题的i*i得到的结果分割出来加起来要等于i
        //我们来举个例子，假设i是36,i*i=36*36=1296   我们可以用回溯法，一点点来试试
        //首先我们分割出第一个位，1296中的1；我们知道答案要是36， 那是不是意味着接下来的296分割出来的值要满足35（36-1）
        //然后以此往下递归，最后返回真或假，这就是整体的答案


        int result=0;
        for (int i = 1; i <= n; i++) {
            int x = i * i;
            if (check(String.valueOf(x),i)) {
                result+=x;
            }
        }
        return result;
    }

    public boolean check(String x,int target){
        int length = x.length();
        if (Integer.parseInt(x)==target) {
            return true;
        }
        if (Integer.parseInt(x)<target){
            return false;
        }
        for (int i = 1; i < length; i++) {
            String splitInt = x.substring(0, i);
            String nexX = x.substring(i);

            if (check(nexX,target-Integer.parseInt(splitInt))){
                //当anser为true时说明找到了答案
                return true;
            }
        }
        return false;
    }

}
