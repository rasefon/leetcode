/**
 * Created by rasefon on 16-7-2.
 */
public class Main {

    public static void main(String[] args) {
        LargestRectangleArea84 largestRectangleArea84 = new LargestRectangleArea84();
        int[] data = new int[20000];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        int result = largestRectangleArea84.largestRectangleArea(data);
//        int result = largestRectangleArea84.largestRectangleArea(new int[]{4,2,0,3,2,5});
        System.out.print(result);
    }
}
