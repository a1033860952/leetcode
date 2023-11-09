package leetcode_2000_3000;

import java.util.*;

public class Leetcode_2127 {


    public int maximumInvitations(int[] favorite) {

        //从 i 向 favorite[i]连边，可以得到一张有向图,注意i是i同学喜欢favorite[i]同学
        //通过这个可以画出一个有向图，比如i喜欢j，那么就可以画成i->j,如果相互喜欢那么就是i <-> j 双向箭头，可以自己画一画
        //接下来这段定义注意了，如果大小为 k 的连通块（图）， 有 k 个点和 k 条边，且由于每个点的出度均为1 ，那么这样的有向图就叫做“内向基环树“
        //k个点有k条边一定有环，因为如果没有环的话，一定是k-1条边，比如一条执行的图，不信的可以自己画一画看看

        //基环树又分为内向基环树和外向基环树，而基环树组成的森林就叫作基环树森林 (pseudoforest)
        //注意，我们知道基环树一定有环，但是这个环不一定能包含所有的顶点的，比如有10个顶点，只有三个是成环的，还剩下7个没有在环内，会在环外连接
        //说回内向基环树和外向基环树，「内向」是指树中任意节点有且只有一条出边，啥意思呢 ，用题目来说就是每个同学只能喜欢一个同学，不能喜欢多个
        //而外向基环树是指一个同学只能被另一个同学喜欢，不能被一个以上的同学喜欢
        //从题目来看，每位员工都有一位 喜欢 的员工，也就是说每个同学只能喜欢一个同学，那么就是内向基环树了

        //我们在用另一个说法来说明内向基环树，每一个内向基环树（连通块）都由一个基环（就是环）和其余指向基环的树枝组成
        //基环是可以两个节点就组成的，必须两个循环了，也是环嘛，
        //所以在这题中，环可以是两个或两个以上，所以要分为两种可能来讨论，也就是说这两类基环树在组成圆桌时会有明显区别

        //首先讨论环是两个以上节点组成的，也就是至少3个组成的环，那么我们仔细想一想，在环外面的树枝能加入这个环吗
        //注意题目，只有当喜欢的人在自己旁边时，才会坐下来，如果这个时候有人像进入这个圆环（圆桌）的时候，一定会破坏这个规则，让某个人不在自己喜欢的人旁边（不信的可以自己画图看看）
        //而且注意题目，k个点有k个边，所以一定只存在一个圆环，因为如果圆环的话，一定会有一个节点飘在整个图外面，和图没有任何联系，但是在此题中是不可能的
        //因为这个节点（同学）是会喜欢另一个（节点）同学的，他一定是有和其他节点有关系的
        //所以我们可以得出结论，如果基环是由2个以上的节点组成的，那么能组成的最大圆桌就是人数就是这个基环的节点数

        //分析完两个以上的圆环后，我们可以开始分析节点为两个的圆环，首先再次明确，此题根据提议只会存在一个环
        //此环中有两个节点，那么就反着找，比如先看第一个节点除了基环节点，还有那个节点喜欢第一个节点
        //然后一直反着找，看看找到最远的那个节点时，整条线上的节点数是多少，另一个节点也是一样的，以此类推，反着找
        //最后两个节点都找到自己最长线的长度，然后加起来，就是一个题目的答案了
        //注意可能有多个基环长度为2的基环树（？？  不确定 保持怀疑）



        //首先我们可以使用拓扑排序将基环和树枝区分开，拓扑排序是取入度为0的节点，而基环是一个环，环内的节点不会存在入度为0的，毕竟相互依赖了

        //先计算每个节点的入度
        int length = favorite.length;
        int[] penetration=new int[length];
        for (int i : favorite) {
            penetration[i]++;
        }

        //创建反图，用于查找只有2个节点时的最长路径
        List<Integer>[] inverseGraph=new ArrayList[length];
        Arrays.setAll(inverseGraph,e->new ArrayList<>());

        //创建拓扑排序的拓扑队列，也就是将图中的入度为0的节点放进去
        //创建反图的过程可以在拓扑排序中完成，这样创建的反图是不包含基环的，遍历的时候更方便
        Queue<Integer> topologyQueue =new ArrayDeque<>();
        //但是这只是第一轮，这个相当于只是剪掉最外面的树枝
        for (int i = 0; i < penetration.length; i++) {
            if (penetration[i]==0){
                topologyQueue.add(i);
            }
        }

        //循环剪掉树枝，并构建反图
        while (!topologyQueue.isEmpty()){
            //获取队列第一个节点
            Integer x = topologyQueue.poll();
            //然后看看这个x喜欢了谁
            int y = favorite[x];
            //反图记录下y喜欢的人是谁
            inverseGraph[y].add(x);
            //接下来顺便看看剪掉x后，y是不是也能剪掉，如果能剪掉，可以把y也放进队列中
            if (--penetration[y]==0) {
                //顺便说下，注意这个--penetration[y]，这个操作会对自己进行修改的，--操作
                topologyQueue.add(y);
            }
        }


        //基环大于3时会用这个
        int maxRingSize = 0;
        //当基环位2时的两边链条的长度
        int sumChainSize = 0;

        //接下来就是循环找基环有多长
        for (int i = 0; i < length; i++) {
            // 基环长度
            int ringMax=1;
            //当节点的入度为0的的时候，这个节点肯定不是基环其中之一，都没人喜欢他
            if (penetration[i]==0) {
                continue;
            }

            //肯定有疑问，为什么找基环的循环要在这个循环里，因为当基环长度为2时，你能知道哪里是基环的开头和结束
            //这段就是找基环了;  一直循环下去，只要有环后面一定是会等于最开始的自己的，所以y!=i才是循环继续往下的关键，当这个y==i了，那就说明环已经结束了
            //而且这里的开始，一定是基环的开始，为什么呢，因为前面的操作会导致不是基环的节点，深度都是0
            for (int y=favorite[i]; y!=i;y=favorite[y]){
                //这段是避免重复访问的，
                penetration[y] = 0;
                ringMax++;
            }

            if (ringMax==2){
                sumChainSize+=getMaxDepth(i,inverseGraph)+getMaxDepth(favorite[i],inverseGraph);
            }else{
                maxRingSize=Math.max(maxRingSize,ringMax);
            }

        }
        return Math.max(maxRingSize,sumChainSize);



    }


    /**
     * 获取反图中最深的那条线长度
     * @param x
     * @param inverseGraph
     * @return
     */
    private int getMaxDepth(int x,List<Integer>[] inverseGraph){

        int maxDepth=1;
        for (Integer son : inverseGraph[x]) {
            maxDepth=Math.max(maxDepth,getMaxDepth(son,inverseGraph)+1);
        }

        return maxDepth;
    }
}
