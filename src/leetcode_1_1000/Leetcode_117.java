package leetcode_1_1000;


import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode_117 {
    public Node connect(Node root) {
        //这题我们可以用层序遍历来实现，重点在于在队列中如何分辨那几个节点是一层的，让这一层的最后一个节点的next指向null
        //我们可以用两个循环，第一个循环是判断队列是不是空的，第二个循环就记录下当前队列的数目，然后判断数目是否为null
        //不必多说，看代码
        Node resultNode=root;
        if (root==null){
            return resultNode;
        }

        Queue<Node> nodeQueue=new ArrayDeque<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()){
            //记录下当前队列有多少个节点，这个就是这一层有多少个节点
            int queueSize=nodeQueue.size();
            while (queueSize>0){
                queueSize--;
                Node poll = nodeQueue.poll();
                //获取队列首个节点，不取出队列
                if (queueSize!=0){
                    poll.next=nodeQueue.peek();
                }
                Node leftNode = poll.left;
                Node rightNode = poll.right;
                if (leftNode !=null){
                    nodeQueue.add(leftNode);
                }
                if (rightNode !=null){
                    nodeQueue.add(rightNode);
                }
            }


        }




        return resultNode;



    }
}
