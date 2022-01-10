package item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item10
 * fileName : PointTest
 * author : haedoang
 * date : 2022-01-10
 * description :
 */
class PointTest {
    @Test
    @DisplayName("equals test")
    public void equals() {
        // given
        Point pointA = new Point(3, 5);

        // then
        assertThat(pointA.equals(new Point(3, 5)));
    }
}
