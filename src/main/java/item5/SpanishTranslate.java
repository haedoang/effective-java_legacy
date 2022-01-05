package item5;

/**
 * packageName : item5
 * fileName : EnglishTranslator
 * author : haedoang
 * date : 2022-01-05
 * description :
 */
public class SpanishTranslate implements Translate {

    @Override
    public String translate(String str) {
        if (str.equals("안녕하세요")) {
            return "hola";
        }
        return str;
    }
}
