package item3;

import java.io.Serializable;

/**
 * packageName : item3
 * fileName : Pet
 * author : haedoang
 * date : 2022/01/03
 * description :
 */
public class Pet implements Serializable {
    private transient static final Pet INSTANCE = new Pet();

    private Pet() {
    }

    public static Pet getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
