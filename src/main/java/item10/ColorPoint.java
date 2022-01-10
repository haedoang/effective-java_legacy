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
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if( !(o instanceof ColorPoint)) {
            return false;
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public boolean ignoreColorEquals(Object o) {
        if( !(o instanceof Point)) {
            return false;
        }

        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
