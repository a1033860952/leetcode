package leetcode_1_1000;

public class Leetcode_707 {

    public static void main(String[] args) {


        // Your MyLinkedList object will be instantiated and called as such:
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        obj.get(1);
        obj.deleteAtIndex(1);
        obj.get(1);





    }
}


class MyLinkedList {

    private  ListNode virtuallyHead;
    private int size=0;

    public MyLinkedList() {
        virtuallyHead=new ListNode();

    }

    public int get(int index) {
        if (index>size-1 || size<0) {
            return -1;
        }

        ListNode valueNode=virtuallyHead;
        for (int i = 0; i <= index; i++) {
            if (valueNode.next!=null){
                valueNode=valueNode.next;
            }else{
                return -1;
            }
        }
        return valueNode.val;
    }

    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next= virtuallyHead.next;
        virtuallyHead.next=listNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode valueNode=virtuallyHead;

        while (valueNode.next!=null){
            valueNode=valueNode.next;
        }
        valueNode.next=new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if (index < 0) {
            index = 0;
        }

        ListNode listNode=virtuallyHead;
        for (int i = 0; i < index; i++) {
            listNode=listNode.next;
        }

        ListNode newListNode = new ListNode(val);
        newListNode.next= listNode.next;
        listNode.next= newListNode;

        size++;

    }

    public void deleteAtIndex(int index) {
        if (index>=size || index<0){
            return;
        }

        ListNode listNode=virtuallyHead;
        for (int i = 0; i < index; i++) {
            listNode=listNode.next;

        }
        ListNode deleteListNode = listNode.next;
        listNode.next=deleteListNode.next;

        size--;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
