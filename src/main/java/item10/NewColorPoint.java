package item10;

import java.awt.*;
import java.util.Objects;

/**
 * packageName : item10
 * fileName : ColorPoint
 * author : haedoang
 * date : 2022-01-10
 * description :
 */
public class NewColorPoint {
    private final Color color;
    private final Point point;

    public NewColorPoint(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NewColorPoint)) {
            return false;
        }
        NewColorPoint cp = (NewColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}

