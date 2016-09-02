/**
 * Created by rasefon on 16-9-1.
 */
public class DungeonGame174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int nI = dungeon.length, nJ = dungeon[0].length;
        int[][] minHMap = new int[nI][nJ];

        for (int i = nI - 1; i >= 0; i--) {
            for (int j = nJ - 1; j >= 0; j--) {
                int dVal = dungeon[i][j];
                if (i == nI - 1 && j == nJ - 1) {
                    minHMap[i][j] = (1 - dVal) > 0 ? (1 - dVal) : 1;
                } else {
                    if (i == nI - 1) {
                        minHMap[i][j] = (minHMap[i][j + 1] - dVal) > 0 ? (minHMap[i][j + 1] - dVal) : 1;
                    } else if (j == nJ - 1) {
                        minHMap[i][j] = (minHMap[i + 1][j] - dVal) > 0 ? (minHMap[i + 1][j] - dVal) : 1;
                    } else {
                        int right, down;
                        right = (minHMap[i][j + 1] - dVal) > 0 ? (minHMap[i][j + 1] - dVal) : 1;
                        down = (minHMap[i+1][j] - dVal) > 0 ? (minHMap[i+1][j] - dVal) : 1;
                        minHMap[i][j] = Math.min(right, down);
                    }
                }
            }
        }

        return minHMap[0][0];
    }
}
