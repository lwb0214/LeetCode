/**
 *输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int top = 0, bottom = matrix.length, 
            left = 0, right = matrix[0].length;
        int[] res = new int[bottom * right];

        int j = 0;
        while (true) {
            for (int i = left; i < right; i++) {
                res[j++] = matrix[top][i];
            }
            top++;
            if (top == bottom) {
                break;
            }
            for (int i = top; i < bottom; i++) {
                res[j++] = matrix[i][right - 1];
            }
            right--;
            if (right == left) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                res[j++] = matrix[bottom - 1][i]; 
            }
            bottom--;
            if (bottom == top) {
                break;
            }
            for (int i = bottom - 1; i >= top; i--) {
                res[j++] = matrix[i][left];
            }
            left++;
            if (left == right) {
                break;
            }
        }
        return res;
    }
}