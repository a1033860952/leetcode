package leetcode_1_1000;

import java.util.Stack;

/**
 * @author tianling
 * @description:
 * @since 2024/1/14
 */
public class Leetcode_232 {
    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();


    }

}


class MyQueue {

    // 使用栈来实现队列，用栈结构，我们可以使用java的之前就写好的stack来实现
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        // 此栈用于数据写入
        stackIn=new Stack<>();
        // 此栈用于将写出数据
        stackOut=new Stack<>();

    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackOut();
        return stackOut.pop();
    }

    private void dumpStackOut() {
        if (!stackOut.isEmpty()) {
            return;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }

    }

    public int peek() {
        dumpStackOut();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
