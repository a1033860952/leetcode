package leetcode_1_1000;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author tianling
 * @description:
 * @since 2024/1/17
 */
public class Leetcode_20 {

    public static void main(String[] args) {
        Leetcode_20 leetcode20=new Leetcode_20();
        System.out.println(leetcode20.isValid("(]"));
    }


    public boolean isValid(String s) {
        // 这题是栈的一个典型应用，我们知道栈是后进先出的，而符号大概有以下几种组合
        // () {} []  正常情况下一定是组合的第一个入栈，然后再入组合的第二个
        // 左边组合无所谓，无脑放进去，主要是右边的，我们都不需要放进去，我要只要拿到最顶端的匹配下是不是相等的，若不相等肯定有问题了
        // 入栈是时候我们就统一入右符号，这样判断相等的时候会更方便些，比如入的是{，但实际入栈的是}
        //接下来分析下可能出现的情况：
        // 第一种情况：已经遍历完了字符串，但是栈不为空，说明有相应的左括号没有右括号来匹配，所以return false
        //
        // 第二种情况：遍历字符串匹配的过程中，发现栈里没有要匹配的字符。所以return false
        //
        // 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号return false

        ArrayDeque<Character> queue=new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '('){
                queue.push(')');
            }else if (c == '{'){
                queue.push('}');
            }else if (c == '['){
                queue.push(']');
            }else if (!queue.isEmpty() && queue.peek() == c){
                queue.pop();
            }else{
                return false;
            }

        }
        return queue.isEmpty();


    }

}
