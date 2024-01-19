package leetcode_1000_2000;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author tianling
 * @description:
 * @since 2024/1/18
 */
public class Leetcode_1047 {
    public static void main(String[] args) {
        Leetcode_1047 leetcode1047=new Leetcode_1047();
        System.out.println(leetcode1047.removeDuplicates1("abbaca"));
    }

    public String removeDuplicates(String s) {

        //真的，这题不用栈天理难容，别的不说就后进先出你就懂了

        Stack<Character> stack=new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()){
                if (stack.peek()==c) {
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }

        int size = stack.size();
        String[] charArray=new String[size];

        for (int i = size-1; i >= 0; i--) {
            charArray[i]= String.valueOf(stack.pop());
        }

        return String.join("",charArray);

    }


    /**
     * 这是卡尔的写法，它使用了双端队列ArrayDeque来实现栈
     * 这个栈每次push数据的时候，这个数据会始终在下标0.也就是相等于反过来的
     * 这样在最后输出的时候就不需要反转字符串了
     * @param S
     * @return
     */
    public String removeDuplicates1(String S) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        //参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < S.length(); i++) {
            ch = S.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else {
                deque.pop();
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }
}
