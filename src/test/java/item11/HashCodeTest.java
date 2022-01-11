package item11;

import item10.PhoneNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item11
 * fileName : HashCodeTest
 * author : haedoang
 * date : 2022/01/11
 * description :
 */
public class HashCodeTest {
    @Test
    @DisplayName("HashMap은 hash값으로 객체의 일치를 비교한다.")
    public void hashMapTest() {
        // given
        final HashMap<PhoneNumber, String> m = new HashMap<>();
        final PhoneNumber data = new PhoneNumber(707, 867, 5309);
        final PhoneNumber sameData = new PhoneNumber(707, 867, 5309);

        // when
        m.put(data, "제니");

        // then
        assertThat(m.get(sameData)).isNotEqualTo("제니").isNull();
        assertThat(data.hashCode()).isNotEqualTo(sameData.hashCode()).as("HashMap은 해시코드가 다른 엔트리끼리는 동치성 비교를 시도하지 않는다.");
    }
}
