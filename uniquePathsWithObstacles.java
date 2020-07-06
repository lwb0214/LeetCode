/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
// 动态规划
class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }

        for (int j = 0; j < col; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;
            } 
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = obstacleGrid[i][j] == 0 ?
                        dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[row - 1][col - 1]; 
    }
	
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[] dp = new int[col];

        // 递推公式： dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        // 滚动数组优化:：dp[j] = dp[j] + dp[j - 1];
        // 因为i在外层循环，所以（优化后的等式的）等号右边的dp[j]实际上就是上一轮循环的dp[j]的值
        // 即dp[j] = dp[i - 1][j]
        // 注意内层循环必须是递增的，这样dp[j - 1]对应的才是本轮循环的值
        // 即dp[j - 1] = dp[i][j - 1]
        // 注：本轮对应的是i，上一轮对应的是i - 1
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                // 当前网格内有障碍物，则令dp[j] = 0
                // 因为不能经过该网格
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                // 只需要关注本轮循环方格的值（对应obstacleGrid[i][j - 1]），
                // 因为上一轮的值（对应obstacleGrid[i - 1][j]）已经存在dp[j]里
                // 所以，如果无障碍，则更新dp[j]
                else if (j >= 1 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[col - 1];
    }
    
}

