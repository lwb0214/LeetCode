/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * 
 * 示例：
 *
 * matrix = [
 *   [ 1,  5,  9],
 *   [10, 11, 13],
 *   [12, 13, 15]
 * ],
 * k = 8,
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        // left是最小值，right是最大值
        int left = matrix[0][0], right = matrix[len - 1][len - 1];

        // 二分查找
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // checkLessThanK(matrix, mid, k)表示：小于等于mid的值 的 数量 小于k
            /*
                想象一下，mid = 7， k = 5
                说明matrix中小于等于7的值只有（0-4）个，
                举个例子：
                    matrix中有{1 2 7 7 8 9}
                    小于等于7的有{1， 2， 7， 7}
                    第5大的数字，肯定就是从8开始找咯
                那我们要找的是第k小的数字，这个数字肯定要比mid大吧，从mid+1开始找吧
                否则，就从小于等于mid的这个部分来找吧
            */
            if (checkLessThanK(matrix, mid, k)) {
                left = mid + 1;
            } else {
                //小于等于mid的值 的 数量 大于等于k
                right = mid;
            }
        }
        return left;
    }

    //小于等于mid的数量少于K
    public Boolean checkLessThanK(int[][] matrix, int mid, int k) {
        int num = 0;
        int j = 0;
        int i = matrix.length -1;
        
        //这个计数的方法很特别哦，不是一行一行加的。是一列一列加的！
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] <= mid) {
                j++;
                num += i + 1;
            } else {
                i--;
            }
            if (num >= k) return false;
        }
        return true;
    }
	
	/* 归并排序
	   时间复杂度：O(klogn)
       空间复杂度：O(n)  */
	   
	public int kthSmallest2(int[][] matrix, int k) {
        int[] res = merge(matrix, 0, matrix.length - 1);
        return res[k - 1];
    }

    private int[] merge(int[][] matrix, int start, int end) {
        if (start >= end) {
            return matrix[start];
        }
        int mid = (start + end) >>> 1;
        int[] arr1 = merge(matrix, start, mid);
        int[] arr2 = merge(matrix, mid + 1, end);
        return mergeTwoArr(arr1, arr2);
    }

    private int[] mergeTwoArr(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int len1 = arr1.length, len2 = arr2.length;
        int[] res = new int[len1 + len2];
        while(i < len1 && j < len2) {
            res[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }
        while(i < len1) {
            res[k++] = arr1[i++];
        }
        while(j < len2) {
            res[k++] = arr2[j++];
        }
        return res;
    }
    
}
