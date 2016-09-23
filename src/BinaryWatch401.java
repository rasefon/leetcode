import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rasefon on 9/23/16.
 */
public class BinaryWatch401 {

    public static List<String> readBinaryWatch(int num) {
        List<String> retVal = new LinkedList<>();

        for (int i = 0; i <= 12; i++) {
            for (int j = 0; j <= 60; j++) {
                if (Integer.bitCount((i << 6) + j) == num) {
                    retVal.add(String.format("%d:%02d", i, j));
                }
            }
        }

        return retVal;
    }
}
