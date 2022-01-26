package item13;

/**
 * packageName : item13
 * fileName : KoreanPerson
 * author : haedoang
 * date : 2022-01-26
 * description :
 */
public class KoreanPerson extends Person {
    public KoreanPerson(String name, int age) {
        super(name, age);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
