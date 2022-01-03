package item3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item3
 * fileName : MemberTest
 * author : haedoang
 * date : 2022/01/03
 * description :
 */
public class MemberTest {
    @Test
    @DisplayName("enum을 활용한 singleton 보장")
    public void singletonByEnum()  {
        // given
        Member instance = Member.INSTANCE;

        // then
        assertThat(instance).isSameAs(Member.INSTANCE);
    }
}
