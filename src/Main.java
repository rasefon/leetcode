/**
 * Created by rasefon on 16-7-2.
 */
public class Main {

    public static void main(String[] args) {
        PerfectRectangle391 perfectRectangle391 = new PerfectRectangle391();

        boolean result = perfectRectangle391.isRectangleCover(new int[][]{
                {0, 0, 4, 1},
                {7, 0, 8, 2},
                {6, 2, 8, 3},
                {5, 1, 6, 3},
                {4, 0, 5, 1},
                {6, 0, 7, 2},
                {4, 2, 5, 3},
                {2, 1, 4, 3},
                {0, 1, 2, 2},
                {0, 2, 2, 3},
                {4, 1, 5, 2},
                {5, 0, 6, 1}
        });

//        boolean result = perfectRectangle391.isRectangleCover(new int[][]{
//                {0, 0, 3, 3},
//                {1, 1, 2, 2},
//                {1, 1, 2, 2}
//        });

        System.out.print(result);
    }
}
