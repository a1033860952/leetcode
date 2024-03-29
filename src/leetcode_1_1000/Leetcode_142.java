package leetcode_1_1000;

public class Leetcode_142 {


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(-4);
        ListNode node = new ListNode(2, new ListNode(0, listNode1));
        ListNode listNode=new ListNode(3,node);
        listNode1.next=node;
        Leetcode_142 leetcode142 =new Leetcode_142();
        leetcode142.detectCycle(listNode);

    }




    // https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF
    //首先我们需要先得到循环内交接的位置，若对x,y,z各代表的意义是什么不知道的话，可以通过上面的地址去看图片
    // 慢指针交接点的位置是 slow=x+y 而快指针交接的位置是fast= n(z+y)+x+y
    // 又因为快指针速度是快指针的两倍，所以 2(x+y)=n(z+y)+x+y 继续往下推断可以得出 x+y=n(z+y)，因为两边都除以了(x+y),右边就得了x+y抵消掉了
    // 继续往下得 x=n(z+y)-y， n是快指针需要转几圈，这里的n一定大于等于1，不可能是0的，也就是说快指针比如至少转一圈循环才有可能追到慢指针（或者让慢指针碰上它）
    // 那么我们可以让n提一个z+y出来，这样就能得到这个 x=(n-1)(z+y)+z，  为什么是最后是z,因为(z+y)-y=z
    // 从这里就能看出结果了，其中的(n-1)(z+y)其实就是转了几圈，从这个公司就可以看到，不管转了几圈，最后x都能等于z的，毕竟转圈转完之后，就可以消掉(n-1)(z+y)了
    // 最后我们能证明的x=z（其中的 (n-1)(z+y)是转了几圈的距离，这个时候我们是假定它已经转完了）
    // 到最后的时候当快指针将圈全转完的时候就能得到快慢指针的交接点了，同时也证明了一件事情，那就是从交接点到循环入口，和从最开头到循环入口的距离是一样的
    // 这个时候我们再用两个指针，两个指针都是一步一步的往走，最后的到达的地点就是循环的入口节点




    public ListNode detectCycle(ListNode head) {
        ListNode fastNode=head;
        ListNode slowNode=head;

        ListNode relationNode=null;


        if (fastNode==null|| fastNode.next==null || fastNode.next.next==null){
            return null;
        }


        // 先判断是否有环,若有环则获取快指针和满指针的关联节点
        while(fastNode.next != null && fastNode.next.next != null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if (fastNode.equals(slowNode)){
                relationNode=fastNode;
                break;
            }
        }

        if (relationNode==null){
            return null;
        }

        while (true){
            if (head.equals(relationNode)){
                return relationNode;
            }
            head=head.next;
            relationNode=relationNode.next;
        }



    }

}
