package leetcode_1000_2000;

public class Leetcode_1334 {

    //这题本质上可以变成，求某个点到另一个点的距离是否在distanceThreshold中，若存在则+1
    //这题我们可以用存图来解决，先了解下存图的概念，存图可以分为稠密图和稀疏图
    //为了方便下面的解释，我们用n代表点数，m代表边数
    //稠密图：当边数数量接近点数的平方时，即m于等于n的平方 （稠密图一般使用二维矩阵来实现）
    //稀疏图：当边数数量接近点数时，即m约等于n  （稀疏图一般是用邻接表来实现）
    //邻接表又称为链式前向星，实现方式与【使用数组存储单链表】一致（头插法）
    //邻接表具体的实现方式可以看题解，这里就先不处理了
    //当然除了上面这两种存图形式，还有另一种就是类存储，就是用类来存储，每一个类就是一个边，用一个集合装起来，效率很低，所以一般都不用




    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        return 1;
    }
}
