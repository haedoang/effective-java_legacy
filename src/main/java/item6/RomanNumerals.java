package item6;

import java.util.regex.Pattern;

/**
 * packageName : item6
 * fileName : RomanNumerals
 * author : haedoang
 * date : 2022-01-06
 * description :
 */
public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    public static boolean isRomanNumeral(String str) {
        return ROMAN.matcher(str).matches();
    }
}
