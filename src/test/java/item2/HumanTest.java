package item2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : item2
 * fileName : HumanTest
 * author : haedoang
 * date : 2022/01/02
 * description : 점층적 생성자 패턴. Human 도메인은 firstName, lastName, age 를 필수 값으로 가진다. middleName 은 선택사항이다.
 */
class HumanTest {

    @Test
    @DisplayName("객체를 생성하기 위해 생성자를 다양하게 구현하여야 한다.")
    public void telescopingConstructorPattern() throws Exception {
        // when
        Human john = new Human("John", "Kennedy", 46);
        Human johnFullName = new Human("John", "Fitzgerald", "Kennedy", 46);

        // then
        assertAll(
                () -> assertThat(john.getFirstName()).isEqualTo(johnFullName.getFirstName()),
                () -> assertThat(john.getLastName()).isEqualTo(johnFullName.getLastName()),
                () -> assertThat(john.getAge()).isEqualTo(johnFullName.getAge()),
                () -> assertThat(john.getMiddleName()).isNotEqualTo(johnFullName.getMiddleName())
        );
    }
}