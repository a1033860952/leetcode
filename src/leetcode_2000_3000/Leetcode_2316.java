package leetcode_2000_3000;

public class Leetcode_2316 {

    //这个就是用来存储每个元素的父节点
    private int[] parentArray;

    //这个是用来记录每个节点自己有多少深度的
    private int[] size;
    public long countPairs(int n, int[][] edges) {
        parentArray=new int[n];
        size=new int[n];
        //一开始每个元素都是一个集合，每个集合都会有一个主元素，刚开始一个集合都是只有一个元素，自然主元素就是自己了，这个循环就是初始化的
        for (int i = 0; i < n; i++) {
            parentArray[i]=i;
            //一开始 每个节点深度都是1
            size[i]=1;
        }

        //然后设置关系，两个集合合并(主元素判断)，比对大小，输的那元素所在的集合直接依附在主元素下(反过来也可以，无所谓的)
        for (int[] edge : edges) {
            union(edge);
        }

        long result=0;

        for (int i = 0; i < n; i++) {
            //先获取到i元素的真正父节点
            int parent = find(i);
            //n減去父节点当前的深度，就是父节点无法到达的节点数了
            result+=n-size[parent];
        }

        //因为上一个循环是循环所有元素的，所以a元素无法到达b元素，那么b元素自然也无法到达a元素，所以result结果需要除以2
         return result/2;
    }

    private void union(int[] edge) {
        int i = find(edge[0]);
        int j = find(edge[1]);
        if (i==j){
            return;
        }
        //比对两边的父节点，那么更大
        if (i>j){
            //将j所在的真正父节点替换为i的真正父节点
            parentArray[j]=i;
            //i元素的深度就加上j元素深度，j元素本身不用变
            size[i]=size[i]+size[j];
        }else{
            //将i所在的真正父节点替换为j的真正父节点
            parentArray[i]=j;
            size[j]=size[j]+size[i];
        }
    }

    //获取某个元素x的真正父节点
    public int find(int x){
        //由于可能存在某个元素的父节点不是自己真正父节点，所以要循环拿到底
        if (parentArray[x]==x){
            return x;
        }else{
            //这一步很重要，相当于是优化结构了，每次查找的时候将父节点往上挂，最后节点之间会变得很均匀 优化速度
            parentArray[x]=find(parentArray[x]);
            return parentArray[x];
//            return find(parentArray[x]);

        }

    }




}
