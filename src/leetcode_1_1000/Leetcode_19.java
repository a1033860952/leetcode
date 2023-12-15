package leetcode_1_1000;

public class Leetcode_19 {
    public static void main(String[] args) {
        // ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Leetcode_19 leetcode19=new Leetcode_19();

        leetcode19.removeNthFromEnd(new ListNode(1),1);


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 这题可以使用快慢指针去实现，我们要删除导数第n个节点
        // 我们可以可以一开始就让快慢指针距离n,这样当块指针走到结尾的时候,对应的慢指针就是需要删除


        ListNode virtuallyNode=new ListNode();
        virtuallyNode.next=head;

        ListNode fastPointNode=virtuallyNode;

        ListNode slowPointNode=fastPointNode;
        for (int i = 0; i < n; i++) {
            slowPointNode=slowPointNode.next;
        }


        while (slowPointNode.next!=null){
            fastPointNode=fastPointNode.next;
            slowPointNode=slowPointNode.next;
        }


        // 此时的fastNode的next就是要删除的节点
        fastPointNode.next=fastPointNode.next.next;


        return virtuallyNode.next;

    }



}
