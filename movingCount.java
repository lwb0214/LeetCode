/***
*
*地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
*一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格
*（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
*
*例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
*但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
*
***/

//DFS
//进位时产生数位和突变（如19->20:10->2）
class Solution {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n]; //默认为false
        //初始化
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        // 越界 / 数位和超k / visited
        if(i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        // 向下+向右
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) 
                + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}

class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<int[]>();
        queue.add(new int[] { 0, 0, 0, 0 });
        while(queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res ++;
            queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }
}