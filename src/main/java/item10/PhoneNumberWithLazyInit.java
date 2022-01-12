package item10;

import java.util.Objects;

/**
 * packageName : item10
 * fileName : PhoneNumber
 * author : haedoang
 * date : 2022/01/11
 * description :
 */
public class PhoneNumberWithLazyInit {
    private final short areaCode;
    private final short prefix;
    private final short lineNum;

    private int hashCode;

    public PhoneNumberWithLazyInit(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumberWithLazyInit)) {
            return false;
        }
        PhoneNumberWithLazyInit that = (PhoneNumberWithLazyInit) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
       int result = hashCode;
       if (result == 0) {
           result = Short.hashCode(areaCode);
           result = 31 * result +  Short.hashCode(prefix);
           result = 31 * result + Short.hashCode(lineNum);
           hashCode = result;
       }
       return result;
    }

    public int getHashCode() {
        return hashCode;
    }
}
