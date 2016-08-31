/**
 * Created by rasefon on 16-8-30.
 */
public class MaximalRectangle85 {

    public int maximalRectangle(char[][] matrix) {
        int nI = matrix.length;
        if (nI == 0) {
            return 0;
        }

        int nJ = matrix[0].length;
        if (nJ == 0) {
            return 0;
        }

        int[][] mi = new int[nI][nJ];
        for (int i = 0; i < nI; i++) {
            for (int j = 0; j < nJ; j++) {
                if (i == 0) {
                    mi[i][j] = (matrix[i][j] == 0) ? 0 : 1;
                } else {
                    mi[i][j] = (matrix[i][j] == 0) ? 0 : mi[i - 1][j] + 1;
                }
            }
        }

        LargestRectangleArea84 largestRectangleArea84 = new LargestRectangleArea84();
        int max = 0;
        for (int i = 0; i < nI; i++) {
            int val = largestRectangleArea84.largestRectangleArea(mi[i]);
            max = max < val ? val : max;
        }

        return max;
    }
}
