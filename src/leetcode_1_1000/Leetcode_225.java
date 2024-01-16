package leetcode_1_1000;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tianling
 * @description:
 * @since 2024/1/15
 */
public class Leetcode_225 {

    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }



}

class MyStack {
    // 使用队列实现栈
    // 这题要使用两个队列，一个主队列，一个辅助队列
    // 入的时候全入到第一个队列中，但是出的时候不一样
    // 比如我刚开始第一个队列（往右方向的）入了a b c d
    // 那么在pop的时候就把b c d 拿出来，放到辅助队列中，然后pop完之后再弄回主队列中
    // (甚至在java中，可以直接把主队列丢弃掉，然后把主队列地址指向辅助队列，然后辅助队列再重新new个队列出来)
    // 这样就能队列实现栈了


    // 但是其实一个队列也能实现的，直接把队列除了最后一个之外，其他的全都拿出来再加回去
    // 这样也能实现，还不用额外的空间



    private ArrayDeque<Integer> mainQueue;

    public MyStack() {
        mainQueue=new ArrayDeque<>();

    }

    public void push(int x) {
        mainQueue.add(x);
    }

    public int pop() {
        int size = mainQueue.size();
        while (--size>0){
            mainQueue.add(mainQueue.pop());
        }
        return mainQueue.pop();
    }

    public int top() {
        return mainQueue.peekLast();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
