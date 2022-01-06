package item6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item6
 * fileName : RomanNumeralsTest
 * author : haedoang
 * date : 2022-01-06
 * description : 불필요한 객체를 생성하지 않게 Pattern 객체를 static 변수로 선언
 */
class RomanNumeralsTest {

    @Test
    @DisplayName("로마어인지 검증하기")
    public void isRoman() {
        // given
        String given = "IV";

        // when
        boolean romanNumeral = RomanNumerals.isRomanNumeral(given);

        // then
        assertThat(romanNumeral).isTrue();
    }


    @Test
    @DisplayName("클래스 초기화 시 객체를 생성하는 RomanNumerals 의 성능이 더 우수하다")
    public void compare() {
        // given
        String given = "IIIIIIIIIIIIIIIIIIIIIIIIIIII";

        // when
        long start = System.currentTimeMillis();
        NumberUtil.isRomanNumeral(given);
        long result1
                = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        RomanNumerals.isRomanNumeral(given);
        long result2
                = System.currentTimeMillis() - start;

        // then
        assertThat(result1).isGreaterThan(result2);
    }
}
