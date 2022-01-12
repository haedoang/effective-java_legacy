package item11;

import item10.PhoneNumberWithHash;
import item10.PhoneNumber;
import item10.PhoneNumberWithLazyInit;
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

    @Test
    @DisplayName("기본타입을 매개변수로 받는 박싱 클래스의 해시코드는 기본타입의 값과 일치한다.")
    public void boxClassHashTest() {
        // given
        short areaCode = 02;
        int age = 34;

        // when
        int ageHash = Integer.hashCode(age);
        int areaCodeHash = Short.hashCode(areaCode);

        // then
        assertThat(ageHash).isEqualTo(age);
        assertThat(areaCodeHash).isEqualTo(areaCode);
    }

    @Test
    @DisplayName("재정의한 hashcode 로 동치성 검사하기")
    public void HashTest() {
        // given
        final HashMap<PhoneNumberWithHash, String> m = new HashMap<>();
        final PhoneNumberWithHash data = new PhoneNumberWithHash(707, 867, 5309);
        final PhoneNumberWithHash sameData = new PhoneNumberWithHash(707, 867, 5309);
        final PhoneNumberWithHash notSameData = new PhoneNumberWithHash(808, 888, 8888);

        // when
        m.put(data, "제니");

        // then
        assertThat(m.get(sameData)).isEqualTo("제니");
        assertThat(data.hashCode()).isEqualTo(sameData.hashCode())
                .as("기본타입은 Box 클래스의 해시코드로 생성하는것이 좋다")
                .as("Box 클래스는 해시코드의 매개변수로 기본타입이 올 경우 기본타입의 값으로 해시코드를 반환한다")
                .as("따라서, 기본타입의 값이 동일한 경우 같은 해시코드 값을 반환한다");

        assertThat(m.get(notSameData)).isNull();
        assertThat(data.hashCode()).isNotEqualTo(notSameData.hashCode());
    }

    @Test
    @DisplayName("초기화 지연을 통해 해시코드값 반환하기 : thread safe")
    public void test() {
        // given
        final PhoneNumberWithLazyInit phoneNumber = new PhoneNumberWithLazyInit(707, 867, 5309);

        // then
        assertThat(phoneNumber.getHashCode()).isEqualTo(0).as("hashcode를 조회하기 전까지는 hashCode 필드 값은 초기값이다.");
        assertThat(phoneNumber.getHashCode()).isNotEqualTo(phoneNumber.hashCode());
    }
}
