package item2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : item2
 * fileName : HamburgerTest
 * author : haedoang
 * date : 2022/01/02
 * description : 계층적으로 설계된 클래스에서의 빌더 패턴 사용
 *
 */
class HamburgerTest {

    @Test
    @DisplayName("계층적으로 설계된 클래스의 빌더 패턴 사용을 적용하면 확장성을 높일 수 있다.")
    public void hamburger() {
        // given
        MomsTouchBurger 빅치즈치킨버거 = new MomsTouchBurger.Builder(MomsTouchBurger.Size.LARGE)
                .addItem(Hamburger.Item.CHEESE)
                .addItem(Hamburger.Item.CHICKEN)
                .build();

        GordonRamsayBurger 채식버거 = new GordonRamsayBurger.Builder()
                .addItem(Hamburger.Item.SOYBEAN)
                .isVegan()
                .build();

        // then
        assertAll(
                () -> assertThat(빅치즈치킨버거.getItems()).hasSize(2),
                () -> assertThat(빅치즈치킨버거.getSize()).isEqualTo(MomsTouchBurger.Size.LARGE),
                () -> assertThat(채식버거.getItems()).hasSize(1),
                () -> assertThat(채식버거.isVegan()).isTrue()
        );
    }
}