package item8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : item8
 * fileName : FinalizableTest
 * author : haedoang
 * date : 2022/01/08
 * description :
 */
class FinalizableTest {

    @Test
    @DisplayName("bufferedReader를 활용하여 파일 읽기")
    public void finalizable() throws Exception {
        // given
        Finalizable finalizable = new Finalizable();

        // when
        String actual = finalizable.readFirstLine();

        // then
        assertThat(actual).isEqualTo("hello");
        assertThat(finalizable.isClose()).isFalse();
    }

    @Test
    @DisplayName("finalizable 객체는 사용 후 닫아주어야 한다.")
    public void doFinalize() throws IOException {
        // given
        Finalizable finalizable = new Finalizable();
        finalizable.readFirstLine();

        // when
        finalizable.finalize();

        // then
        assertThat(finalizable.isClose()).isTrue();
    }

    @Test
    @DisplayName("가비지 컬렉터가 finalize 메소드를 호출한다")
    public void garbageCollector() throws IOException {
        String firstLine = new Finalizable().readFirstLine();
        assertEquals("hello", firstLine);
        System.gc();
    }

}