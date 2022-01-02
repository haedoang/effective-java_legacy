package item2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * packageName : item2
 * fileName : PetTest
 * author : haedoang
 * date : 2022/01/02
 * description : 자바빈즈패턴은 일관성이 깨지며, 불변으로 만들 수 없다.
 */
class PetTest {
    @Test
    @DisplayName("자바빈즈패턴을 사용하여 객체의 값을 할당한다.")
    public void javaBeansPattern() {
        // given
        Pet pet = new Pet(); //객체를 생성하고 값을 할당하기 전까지 불완전한 객체 상태로 있어야 한다.

        // when
        pet.setAge(5);
        pet.setName("Jerry");
        pet.setOwner("haedong");

        // then
        assertAll(
                () -> assertThat(pet.getAge()).isEqualTo(5),
                () -> assertThat(pet.getName()).isEqualTo("Jerry"),
                () -> assertThat(pet.getOwner()).isEqualTo("haedong")
        );
    }
}