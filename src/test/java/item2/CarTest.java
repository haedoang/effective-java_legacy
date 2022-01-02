package item2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : item2
 * fileName : CarTest
 * author : haedoang
 * date : 2022/01/02
 * description : 빌더 패턴을 적용한 Car 도메인, name, price는 필수적이며, releaseDate, option1, option2은 선택사항이다.
 */
class CarTest {
    @Test
    @DisplayName("빌더 패턴으로 객체 생성하기")
    public void builderPattern() throws Exception {
        // given
        Car car = new Car.Builder("118d", BigDecimal.valueOf(40_000_000L)).build();
        Car carWithSunroof = new Car.Builder("118d", BigDecimal.valueOf(40_000_000L)).releaseDate(LocalDateTime.now())
                .option1("sunroof").build();
        // then
        assertAll(
                () -> assertThat(car.getName()).isEqualTo(carWithSunroof.getName()),
                () -> assertThat(car.getPrice()).isEqualTo(carWithSunroof.getPrice()),
                () -> assertThat(car.getOption1()).isNotEqualTo(carWithSunroof.getOption1())
        );
    }
}