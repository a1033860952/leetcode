package leetcode_1_1000;

public class Leetcode_203 {

    public static void main(String[] args) {
        ListNode listNode=new ListNode(7,new ListNode(7,new ListNode(8,new ListNode(7))));

        Leetcode_203 leetcode203=new Leetcode_203();
        leetcode203.removeElements(listNode,7);

    }


    public ListNode removeElements(ListNode head, int val) {

        ListNode virtuallyNode=new ListNode();
        virtuallyNode.next=head;

        ListNode currentNode=virtuallyNode;
        while (currentNode!=null){

            if (currentNode.next!=null  && currentNode.next.val==val){
                currentNode.next=currentNode.next.next;
            }else{
                currentNode=currentNode.next;
            }


        }

        return virtuallyNode.next;

    }
}
