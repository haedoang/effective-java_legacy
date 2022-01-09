package item9;

import item9.FileUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : PACKAGE_NAME
 * fileName : item9.FileUtilTest
 * author : haedoang
 * date : 2022/01/09
 * description :
 */
class FileUtilTest {
    @Test
    @DisplayName("try & finally 파일 읽기 테스트")
    public void readFile() throws IOException {
        // given
        String path = "src/main/resources/file.txt";

        // when
        String actual = FileUtil.readFirstLineOfFile(path);

        // then
        assertThat(actual).isEqualTo("hello");
    }

    @Test
    @DisplayName("try & finally 파일 쓰기 테스트")
    public void copy() throws IOException {
        // given
        String src = "src/main/resources/file.txt";
        String target = "src/main/resources/file_copy.txt";

        // when
        FileUtil.copy(src, target);

        // then
        assertThat(new File(target).exists()).isTrue();
    }
}