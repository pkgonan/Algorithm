package LeetCode.Common.Hard;

/**
 * LeetCode
 * Problem : https://leetcode.com/problems/longest-increasing-path-in-a-matrix
 **/
public class LongestIncreasingPathInAMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) return 0;
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int iLength = matrix.length;
        int jLength = matrix[0].length;
        int[][] memory = new int[iLength][jLength];
        int maxResult = 0;

        for (int i = 0; i < iLength; i++)
            for (int j = 0; j < jLength; j++)
                maxResult = Math.max(dfs(matrix, i, j, memory), maxResult);

        return maxResult;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memory) {
        if (memory[i][j] != 0) {
            return memory[i][j];
        }

        int left = isValid(matrix, i, j, i - 1, j) ? dfs(matrix, i - 1, j, memory) + 1 : 1;
        int right = isValid(matrix, i, j, i + 1, j) ? dfs(matrix, i + 1, j, memory) + 1 : 1;
        int up = isValid(matrix, i, j, i, j - 1) ? dfs(matrix, i, j - 1, memory) + 1 : 1;
        int down = isValid(matrix, i, j, i, j + 1) ? dfs(matrix, i, j + 1, memory) + 1 : 1;

        int max = Math.max(left, 1);
        max = Math.max(right, max);
        max = Math.max(up, max);
        max = Math.max(down, max);

        memory[i][j] = max;

        return max;
    }

    private boolean isValid(int[][] matrix, int i, int j, int ni, int nj) {
        if (0 > i || 0 > ni || matrix.length <= i || matrix.length <= ni) return false;
        if (0 > j || 0 > nj || matrix[i].length <= j || matrix[i].length <= nj) return false;
        if (matrix[i][j] >= matrix[ni][nj]) return false;

        return true;
    }
}
