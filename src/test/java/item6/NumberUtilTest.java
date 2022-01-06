package item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item6
 * fileName : NumberUtilTest
 * author : haedoang
 * date : 2022-01-06
 * description :
 */
class NumberUtilTest {
    @Test
    @DisplayName("로마어인지 검증하기")
    public void objectTest() {
        // given
        String given = "III";

        // then
        boolean actual = NumberUtil.isRomanNumeral(given);

        // then
        assertThat(actual).isEqualTo(true);
    }
}
