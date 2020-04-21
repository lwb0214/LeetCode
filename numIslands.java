/**
*给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
*岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
*此外，你可以假设该网格的四条边均被水包围。
*
*示例 1:
*输入:
*11110
*11010
*11000
*00000
*输出: 1
*/
class Solution {
	
    private int row;
    private int col;
	
    void dfs(char[][] grid, int r, int c) {
        //边界条件
        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0') {
            return;
        }
        //标记为已访问
        grid[r][c] = '0';
        //向四周深入
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        row = grid.length;
        col = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    //以当前位置为起点，向四周深入
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;

    }
}
