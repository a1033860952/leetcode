package other_topic;

import leetcode_1_1000.ListNode;
// 面试题 02.07. 链表相交
public class leetcode_02_07 {

    public static void main(String[] args) {
        leetcode_02_07 leetcode0207=new leetcode_02_07();

        ListNode intersectNode = new ListNode(8, new ListNode(4, new ListNode(5)));

        ListNode headA = new ListNode(4, new ListNode(1,intersectNode ));

        ListNode headB = new ListNode(5, new ListNode(0,new ListNode(1,intersectNode )));

        leetcode0207.getIntersectionNode(headA,headB);


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 首先这题是求第一个交接点，假设两个链表之间缺少存在交接点
        // 那么是不是两个链表的交接点以及之后的部分都是一样的  对吧

        // 所以我们需要先知道两个链表的长度，并算出两个长度之间的差值n
        // 并使用使用两个指针，分别指到两个链表的倒数第n节点上上面，判断是否相同
        // 若相同，则这就是交接节点




        // 先计算两个链表的长度
        int headAsize=0;
        int headBsize=0;

        ListNode virtuallyHeadAnode = new ListNode();
        virtuallyHeadAnode.next=headA;

        ListNode virtuallyHeadBnode = new ListNode();
        virtuallyHeadBnode.next=headB;


        while (virtuallyHeadAnode.next!=null || virtuallyHeadBnode.next!=null){

            if (virtuallyHeadAnode.next!=null){
                virtuallyHeadAnode=virtuallyHeadAnode.next;
                headAsize++;
            }

            if (virtuallyHeadBnode.next!=null){
                virtuallyHeadBnode=virtuallyHeadBnode.next;
                headBsize++;
            }
        }



        int diffe = Math.abs(headAsize - headBsize);



        for (int i = 0; i < diffe; i++) {
            if (headAsize>headBsize){
                headA=headA.next;
            }else{
                headB=headB.next;
            }
        }


        while (headA!=null && headB!=null){
            if (headA.equals(headB)){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }

        return null;

    }

}
