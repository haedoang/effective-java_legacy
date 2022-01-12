package item10;

/**
 * packageName : item10
 * fileName : NewPhoneNumber
 * author : haedoang
 * date : 2022-01-12
 * description :
 */
public class PhoneNumberWithHash {
    private final short areaCode;
    private final short prefix;
    private final short lineNum;

    public PhoneNumberWithHash(int areaCode, int prefix, int lineNum) {
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
        if (!(o instanceof PhoneNumberWithHash)) {
            return false;
        }
        PhoneNumberWithHash that = (PhoneNumberWithHash) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
}
