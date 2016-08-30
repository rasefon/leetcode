/**
 * Created by rasefon on 16-7-2.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int pathNum[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            pathNum[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            pathNum[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
            }
        }

        return pathNum[m - 1][n - 1];
    }
}
