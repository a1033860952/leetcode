package leetcode_1_1000;

import java.util.Stack;

/**
 * @author tianling
 * @description:
 * @since 2024/1/19
 */
public class Leetcode_150 {

    public static void main(String[] args) {
        Leetcode_150 leetcode150=new Leetcode_150();
        System.out.println(leetcode150.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));

    }

    public int evalRPN(String[] tokens) {
        //别的不说了，这题可以用栈来解决

        Stack<Integer> stack=new Stack<>();

        for (String token : tokens) {
            if ("+".equals(token)){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second+first);
            }else if("-".equals(token)){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second-first);
            }else if("*".equals(token)){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second*first);
            }else if("/".equals(token)){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second/first);
            }else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();

    }
}
