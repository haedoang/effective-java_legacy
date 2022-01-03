package item3;

import java.io.Serializable;

/**
 * packageName : item3
 * fileName : Person
 * author : haedoang
 * date : 2022/01/03
 * description : 싱글톤 도메인
 */
public class Person implements Serializable {
    public static final Person INSTANCE = new Person();
    
    private Person() {
    }
}
