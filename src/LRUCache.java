import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 此题可以用双向链表加一个哨兵节点来作为数据的存储，而哨兵节点的之前节点就是此链表的最老的一个，next节点就是最新的节点
 * get和put必须是0(1)平均时间运行的，可以用hashMap，它的get与put就是O(1)的
 * 判断是否出超出容量了，可以判断map的尺寸来实现的
 * 创建一个node节点结构，且结构中需要有key  value  pre next
 *
 */
class LRUCache {


    private Map<Integer,lrcNode> integerlrcNodeMap;

    //哨兵节点
    private lrcNode dummy;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        dummy=new lrcNode();
        dummy.pre=dummy;
        dummy.next=dummy;
        integerlrcNodeMap=new HashMap<>();
    }

    public int get(int key) {
        lrcNode lrcNode = getNode(key);
        if (lrcNode==null){
//            System.out.println(-1);
            return -1;
        }
//        System.out.println(lrcNode.value);
        return lrcNode.value;
    }

    public void put(int key, int value) {

        //判断当前节点是否存在
        lrcNode node = getNode(key);
        if (node!=null){
            node.setValue(value);
            return;
        }

        lrcNode lrcNode = new lrcNode(key, value);
        integerlrcNodeMap.put(key,lrcNode);
        putFront(lrcNode);

        if (integerlrcNodeMap.size()>capacity){

            integerlrcNodeMap.remove(dummy.pre.key);
            //移除掉最后一个节点
            remove(dummy.pre);

        }



    }

    private lrcNode getNode(int key){
        if (!integerlrcNodeMap.containsKey(key)){
            return null;
        }
        lrcNode lrcNode = integerlrcNodeMap.get(key);
        remove(lrcNode);
        putFront(lrcNode);
        return lrcNode;

    }


    private void putFront(lrcNode lrcNode){
//      这一个操作就是将lrcNode 节点放在最前面

        //将之前的第一个节点设置为第二个节点
        lrcNode.next=dummy.next;

        //设置当前节点pre为哨兵节点
        lrcNode.pre=dummy;

        //设置哨兵的next节点为当前节点
        dummy.next=lrcNode;

        //设置之前的第一节点的pre节点为当前节点
        lrcNode.next.pre=lrcNode;

    }

    private void remove(lrcNode lrcNode){
        lrcNode.pre.next=lrcNode.next;
        lrcNode.next.pre=lrcNode.pre;

    }


    class lrcNode {
        private int key;
        private int value;

        private lrcNode pre;

        private lrcNode next;

        public lrcNode() {
        }

        public lrcNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public lrcNode getPre() {
            return pre;
        }

        public void setPre(lrcNode pre) {
            this.pre = pre;
        }

        public lrcNode getNext() {
            return next;
        }

        public void setNext(lrcNode next) {
            this.next = next;
        }
    }


}