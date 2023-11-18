package leetcode_2000_3000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode_2258 {
    public int maximumMinutes(int[][] grid) {

        //先说模板，二分法加BFS
        //假设存在一个最晚值，也就是x分钟后还能安全到达安全屋，那么x分钟之前的时间也一定可以安全到达安全屋
        //不考虑墙的情况下，火势会在棋盘大小之前烧掉全部草地，即n*m,同时根据这个也可以得出这个时间答案一定在n*m中
        //又假设我们写了一个check方法，入参为分钟数t,判断在延迟t分钟后是否还能正常到达安全屋
        //我们有了check方法，又知道了答案是在n*m中，那么接下来我们可以用二分法去看看答案到底在哪里
        //接下来我们就需要解决check方法怎么实现的问题了
        int n = grid.length;
        int m = grid[0].length;


        return 0;
    }


    /**
     * 用于检查t秒后是否还能正常到达安全屋
     *
     * @param t
     * @param n
     * @param m
     * @return
     */
    private boolean check(int[][] grid, int t, int n, int m) {
        //首先我们需要一个二维数组来模拟获取蔓延到哪里了
        int[][] fireGraphic = new int[n][m];
        //然后我们还需要一个二维数组来模拟人走的路径
        int[][] peopleGraphic = new int[n][m];

        Queue<int[]> fireQueue = new ArrayDeque();

        //初始化火焰二维数组
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fireGraphic[i][j] = 1;
                    fireQueue.add(new int[]{i, j});
                }
                if (grid[i][j]==2){
                    fireGraphic[i][j] = 2;
                }
            }
        }

        moveFire(fireGraphic,t,fireQueue);

        //判断起始位置能
        if (fireGraphic[0][0]==1){
            return false;
        }





        return false;

    }

    //用于火势蔓延
    private void moveFire(int[][] fireGraphic, int t, Queue<int[]> fireQueue) {

        List<int[]> queueTmpList = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            fireQueue.addAll(queueTmpList);
            queueTmpList.clear();
            //火会向四周蔓延，也就是说i+1,i-1,j+1,j-1  但是又不会超出棋盘
            while (!fireQueue.isEmpty()) {
                int[] poll = fireQueue.poll();
                int x = poll[0];
                int y = poll[1];
                fireGraphic[x][y]=1;

                addFireQueue(x-1,y,queueTmpList,fireGraphic);
                addFireQueue(x+1,y,queueTmpList,fireGraphic);
                addFireQueue(x,y-1,queueTmpList,fireGraphic);
                addFireQueue(x,y+1,queueTmpList,fireGraphic);

            }
        }

    }

    private void addFireQueue(int x, int y, List<int[]> queueTmpList, int[][] fireGraphic) {
        int xLength = fireGraphic.length;
        int yLength = fireGraphic[0].length;
        if (x<0 || y<0 || x>xLength || y>yLength || fireGraphic[x][y]==1 ||fireGraphic[x][y]==2){
            return;
        }
        queueTmpList.add(new int[]{x,y});

    }

}
