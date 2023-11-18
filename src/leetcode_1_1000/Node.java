package leetcode_1_1000;

public class Node {
    int val;
    public Node left;
    public Node right;

    Node next;
    Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next=next;
    }
}