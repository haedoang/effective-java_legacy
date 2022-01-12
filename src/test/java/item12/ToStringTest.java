package item12;

import item10.PhoneNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item12
 * fileName : ToStringTest
 * author : haedoang
 * date : 2022-01-12
 * description :
 */
public class ToStringTest {

    @Test
    @DisplayName("toString test")
    public void toStringTest() {
        // given
        PhoneNumber phoneNumber = new PhoneNumber(808, 123, 123);

        // then
        assertThat(phoneNumber.toString()).isEqualTo("808-123-0123");
    }

}
