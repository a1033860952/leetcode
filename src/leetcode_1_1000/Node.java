package leetcode_1_1000;

import java.util.List;

public class Node {
    int val;
    public Node left;
    public Node right;
    public List<Node> children;

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


    public Node(int val, Node left, Node right, List<Node> children, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.children = children;
        this.next = next;
    }
}