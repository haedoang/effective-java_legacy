package item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item10
 * fileName : ColorPointTest
 * author : haedoang
 * date : 2022-01-10
 * description :
 */
class ColorPointTest {

    @Test
    @DisplayName("상속 구현 equals 검증")
    public void extendsEquals() {
        // given
        ColorPoint colorPointA = new ColorPoint(3, 5, Color.RED);
        ColorPoint colorPointB = new ColorPoint(3, 5, Color.RED);

        // then
        assertThat(colorPointA.equals(colorPointB)).isTrue();
        assertThat(colorPointB.equals(colorPointA)).isTrue();
    }

    @Test
    @DisplayName("instance 비교를 하기 떄문에 상속을 통한 equals 는 대칭성이 위배된다.")
    public void extendsCompare() {
        // given
        ColorPoint colorPointA = new ColorPoint(3, 5, Color.RED);
        Point point = new Point(3, 5);

        assertThat(point.equals(colorPointA)).isTrue();
        assertThat(colorPointA.equals(point)).isFalse();
    }

    @Test
    @DisplayName("상속 비교 조건을 추가하여 대칭성을 고려하였으나 추이성이 위배된다.")
    public void ignoreColorWhenPoint() {
        // given
        ColorPoint colorPointA = new ColorPoint(3, 5, Color.RED);
        Point point = new Point(3, 5);
        ColorPoint colorPointC = new ColorPoint(3,5, Color.BLACK);

        assertThat(point.equals(colorPointA)).isTrue();
        assertThat(colorPointA.ignoreColorEquals(point)).isTrue();
        assertThat(colorPointA.ignoreColorEquals(colorPointC)).isFalse();
    }

    @Test
    @DisplayName("상속의 문제를 해결하기 위해 parent 객체만의 비교는 리스코프 치환 원칙을 위배한다.")
    public void lsp() {
        // given
        ColorPoint colorPointA = new ColorPoint(3, 5, Color.RED);
        Point point = new Point(3, 5);

        // then
        assertThat(point.onlyPointEquals(new Point(3,5))).isTrue();
        assertThat(colorPointA.onlyPointEquals(point)).isFalse();
    }
}
