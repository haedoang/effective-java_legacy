package item6;

/**
 * packageName : item6
 * fileName : NunberUtil
 * author : haedoang
 * date : 2022-01-06
 * description :
 */
public class NumberUtil {
    private NumberUtil() {
    }

    public static boolean isRomanNumeral(String str) {
        return str.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }
}
