package item4;

import java.util.Objects;

/**
 * packageName : item4
 * fileName : StringUtil
 * author : haedoang
 * date : 2022-01-05
 * description :
 */
public class StringUtil {
    private StringUtil() {
    }

    public static String[] splitter(String str, String separator) {
        if (Objects.isNull(str) || Objects.isNull(separator)) {
            throw new IllegalArgumentException();
        }
        return str.split(separator);
    }
}
