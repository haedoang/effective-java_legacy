package item9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : item9
 * fileName : NewFileUtilTest
 * author : haedoang
 * date : 2022/01/09
 * description :
 */
class NewFileUtilTest {
    @Test
    @DisplayName("try-with-resource 파일 읽기 테스트")
    public void readFile() throws IOException {
        // given
        String path = "src/main/resources/file.txt";

        // when
        final String actual = NewFileUtil.readFirstLineOfFile(path);

        // then
        assertThat(actual).isEqualTo("hello");
    }

    @Test
    @DisplayName("try-with-resource 파일 쓰기 테스트")
    public void fileCopy() throws IOException {
        // given
        String src = "src/main/resources/file.txt";
        String target = "src/main/resources/file_copy2.txt";

        // when
        NewFileUtil.copy(src, target);

        // then
        assertThat(new File(target).exists()).isTrue();
    }

}