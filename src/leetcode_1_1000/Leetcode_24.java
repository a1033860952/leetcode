package leetcode_1_1000;

public class Leetcode_24 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Leetcode_24 leetcode24=new Leetcode_24();
        leetcode24.swapPairs(listNode);


    }

    public ListNode swapPairs(ListNode head) {
        ListNode virtuallyNode=new ListNode();
        virtuallyNode.next=head;

        ListNode pointNode=virtuallyNode;
        while (pointNode.next!=null && pointNode.next.next!=null){


            // 交换的第一个节点
            ListNode firstNode = pointNode.next;
            // 交换的第二个节点
            ListNode secondNode = pointNode.next.next;


            pointNode.next=secondNode;

            ListNode tmpNode = secondNode.next;

            //将第二个节点指向第一个节点
            secondNode.next=firstNode;

            //将第一个节点指向第三个节点
            firstNode.next=tmpNode;
            pointNode=pointNode.next.next;

        }


        return virtuallyNode.next;




    }

}
