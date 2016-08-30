import java.util.Stack;

/**
 * Created by rasefon on 16-8-29.
 */
public class LargestRectangleArea84 {

    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        if (size == 0) {
            return 0;
        }

        Stack<Integer> dpCon = new Stack<>();
        int max = heights[0];
        int i = 0;
        dpCon.push(i);

        for (i = 1; i <= size; i++) {
            int val = (i == size) ? 0 : heights[i];
            while (!dpCon.empty() && heights[dpCon.peek()] > val) {
                int topIndex = dpCon.pop();
                int width = dpCon.empty() ? i : (i - 1 - dpCon.peek());
                int area = width * heights[topIndex];
                max = max > area ? max : area;
            }

            dpCon.push(i);
        }

        return max;
    }
}
