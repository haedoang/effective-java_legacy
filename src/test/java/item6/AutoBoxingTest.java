package item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item6
 * fileName : AutoBoxingTest
 * author : haedoang
 * date : 2022-01-06
 * @see <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/language/autoboxing.html">autoboxing documentation </a>
 * description :
 */

public class AutoBoxingTest {
    @Test
    @DisplayName("autoboxing 으로 인한 성능 지연 검증하기")
    public void test() {
        // given
        Long autoBoxingGiven = 0L;
        long primitiveGiven = 0;

        // when
        long start = System.currentTimeMillis();
        sum(autoBoxingGiven);
        long autoBoxResult = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        sum(primitiveGiven);
        long primitiveResult = System.currentTimeMillis() - start;

        // then
        assertThat(autoBoxResult).isGreaterThan(primitiveResult);
    }

    private Long sum(Long given) {
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            given += i;
        }
        return given;
    }

    private long sum(long given) {
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            given += i;
        }
        return given;
    }
}
