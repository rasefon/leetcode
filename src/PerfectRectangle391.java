import java.util.HashMap;
import java.util.Map;

/**
 * Created by rasefon on 16-8-30.
 */
public class PerfectRectangle391 {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String key() {
            return x + "-" + y;
        }
    }

    class Rect {
        Point bl, br, tl, tr;

        Rect(int[] rect) {
            bl = new Point(rect[0], rect[1]);
            br = new Point(rect[2], rect[1]);
            tl = new Point(rect[0], rect[3]);
            tr = new Point(rect[2], rect[3]);
        }

        public int area() {
            return (br.x - bl.x) * (tl.y - bl.y);
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        Rect bbox = new Rect(rectangles[0]);
        Map<String, Integer> pointCounter = new HashMap<>();
        pointCounter.put(bbox.bl.key(), 1);
        pointCounter.put(bbox.br.key(), 1);
        pointCounter.put(bbox.tl.key(), 1);
        pointCounter.put(bbox.tr.key(), 1);
        int accArea = bbox.area();

        for (int i = 1; i < rectangles.length; i++) {
            Rect rect = new Rect(rectangles[i]);

            if (rect.bl.x <= bbox.bl.x && rect.bl.y <= bbox.bl.y) {
                bbox.bl = rect.bl;
            }

            if (rect.tl.x <= bbox.tl.x && rect.tl.y >= bbox.tl.y) {
                bbox.tl = rect.tl;
            }

            if (rect.br.x >= bbox.br.x && rect.br.y <= bbox.br.y) {
                bbox.br = rect.br;
            }

            if (rect.tr.x >= bbox.tr.x && rect.tr.y >= bbox.tr.y) {
                bbox.tr = rect.tr;
            }

            genCache(pointCounter, rect.bl);
            genCache(pointCounter, rect.br);
            genCache(pointCounter, rect.tl);
            genCache(pointCounter, rect.tr);

            accArea += rect.area();
        }

        if (bbox.area() != accArea) {
            return false;
        }

        int cornerVal;
        cornerVal = pointCounter.remove(bbox.bl.key());
        if (cornerVal != 1) {
            return false;
        }

        cornerVal = pointCounter.remove(bbox.tl.key());
        if (cornerVal != 1) {
            return false;
        }

        cornerVal = pointCounter.remove(bbox.br.key());
        if (cornerVal != 1) {
            return false;
        }

        cornerVal = pointCounter.remove(bbox.tr.key());
        if (cornerVal != 1) {
            return false;
        }

        for (Map.Entry<String, Integer> entry : pointCounter.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    private void genCache(Map<String, Integer> pointCounter, Point p) {
        Integer val = pointCounter.get(p.key());
        if (val == null) {
            pointCounter.put(p.key(), 1);
        } else {
            pointCounter.put(p.key(), val + 1);
        }
    }
}
