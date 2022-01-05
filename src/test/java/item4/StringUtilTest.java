package item4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item4
 * fileName : StringUtilTest
 * author : haedoang
 * date : 2022-01-05
 * description :
 */
class StringUtilTest {

    @Test
    @DisplayName("유틸클래스 인스턴스화 제한하기")
    public void utilClass() {
        // given
        String email = "haedoang@gmail.com";
        String separator = "@";

        // when
        String[] splitter = StringUtil.splitter(email, separator);

        // then
        assertThat(splitter).hasSize(2);
    }
}
