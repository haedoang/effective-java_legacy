package item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item10
 * fileName : NewColorPointTest
 * author : haedoang
 * date : 2022/01/11
 * description :
 */
class NewColorPointTest {
    @Test
    @DisplayName("상속대신 컴포지션을 활용하기")
    public void composition() {
        // given
        final NewColorPoint newColorPoint = new NewColorPoint(5, 5, Color.RED);

        // then
        assertThat(newColorPoint.asPoint().equals(new Point(5, 5))).isTrue();
    }
}