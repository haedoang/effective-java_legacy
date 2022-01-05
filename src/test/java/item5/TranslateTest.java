package item5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : item5
 * fileName : TranslateTest
 * author : haedoang
 * date : 2022-01-05
 * description :
 */
public class TranslateTest {
    @Test
    @DisplayName("의존 객체를 주입하면 확장이 용이하다.")
    public void injectUtilClass() {
        // given
        String word = "안녕하세요";
        Translator englishTranslator = new Translator(new EnglishTranslate());
        Translator spanishTranslator = new Translator(new SpanishTranslate());

        // when
        String translateToEnglish = englishTranslator.translate(word);
        String translateToSpanish = spanishTranslator.translate(word);

        // then
        assertThat(translateToEnglish).isEqualTo("hello");
        assertThat(translateToSpanish).isEqualTo("hola");
    }
}
