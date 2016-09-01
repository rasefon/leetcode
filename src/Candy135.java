/**
 * Created by rasefon on 16-9-1.
 */
public class Candy135 {
    public int candy(int[] ratings) {
        int sum = 1, currVal = 1;
        boolean cDesc = true, isHEqual = false;
        int hVal = 1, hValI = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                currVal++;
                sum += currVal;
                cDesc = false;
            } else if (ratings[i - 1] == ratings[i]) {
                isHEqual = true;
                cDesc = true;
                hVal = currVal;
                hValI = i - 1;
                currVal = 1;
                sum += currVal;
            } else {
                if (!cDesc) {
                    cDesc = true;
                    hVal = currVal;
                    hValI = i - 1;
                    isHEqual = false;
                    currVal = 1;
                } else {
                    currVal--;
                }

                if (currVal < 1) {
                    currVal = 1;
                    int deltaH = i - hValI;
                    if (deltaH >= hVal && !isHEqual) {
                        sum += deltaH + 1;
                        hVal++;
                    } else {
                        sum += deltaH;
                    }
                } else {
                    sum += currVal;
                }
            }
        }

        return sum;
    }
}
