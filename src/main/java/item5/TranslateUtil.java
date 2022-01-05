package item5;

/**
 * packageName : item5
 * fileName : TranslateUtil
 * author : haedoang
 * date : 2022-01-05
 * description :
 */
public class TranslateUtil {
    private static final EnglishTranslate englishTranslator = new EnglishTranslate();

    public static String translate(String str) {
        return englishTranslator.translate(str);
    }
}
