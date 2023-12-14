package leetcode_1_1000;

public class leetcode_206 {

    public static void main(String[] args) {

        leetcode_206 leetcode206=new leetcode_206();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        leetcode206.reverseList(listNode);
    }



    public ListNode reverseList(ListNode head) {

        // 这题可以使用双指针来实现
        ListNode preNode=null;
        ListNode pastNode=head;
        ListNode tmpNode=null;
        while (pastNode!=null){
             tmpNode = pastNode.next;
            pastNode.next=preNode;
            preNode=pastNode;
            pastNode=tmpNode;
        }

        return preNode;

    }
}
