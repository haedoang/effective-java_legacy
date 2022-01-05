package item5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName : item5
 * fileName : TranslateUtilTest
 * author : haedoang
 * date : 2022-01-05
 * description :
 */
class TranslateUtilTest {
    @Test
    @DisplayName("의존적인 유틸클래스 테스트, 확장이 어렵다.")
    public void dependentUtilClass() {
        // given
        String word = "안녕하세요";

        // when
        String actual = TranslateUtil.translate(word);

        // then
        assertThat(actual).isEqualTo("hello");
    }
}
