/**
*给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

*两个相邻元素间的距离为 1 。
*/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int m=matrix.length, n=matrix[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==0) {	//初始化（0到0的距离为0,直接入队）
                    q.offer(new int[]{i,j});
                }
                else {
                    matrix[i][j]=-1;	//未访问
                }
            }
        }

        int[] dx=new int[] {-1,0,1,0};
        int[] dy=new int[] {0,1,0,-1};
        while(!q.isEmpty()) {
            int[] x_y = q.poll();
            int x=x_y[0];
            int y=x_y[1];
            for(int i=0; i<4; i++) {
                int newX = x_y[0]+dx[i];
                int newY = x_y[1]+dy[i];
                if(newX>=0 && newX<m 
                   && newY>=0 && newY<n 
				   && matrix[newX][newY]==-1) {
						matrix[newX][newY] = matrix[x][y]+1;
                        q.offer(new int[] {newX,newY});
                    }
            }
        }

        return matrix;
    }
}
