/**
 * Created by rasefon on 16-7-2.
 */
public class Main {

    public static void main(String[] args) {
        DungeonGame174 dungeonGame174 = new DungeonGame174();
        int result = dungeonGame174.calculateMinimumHP(new int[][]{
                {1, -3, 3},
                {0, -2, 0},
                {-3, -3, -3}
        });

        System.out.print(result);
    }
}
