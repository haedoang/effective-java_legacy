package item1;

import java.util.Objects;

/**
 * packageName : domain
 * fileName : House
 * author : haedoang
 * date : 2022/01/01
 * description :
 */
public class House {
    private static House instance;
    private String owner;

    private House() {
    }

    private House(String owner) {
        this.owner = owner;
    }

    public static House of(String owner) {
        return new House(owner);
    }

    public static House getInstance() {
        if(Objects.isNull(instance)) {
            instance = new House();
        }
        return instance;
    }

    public static House newInstance() {
        return new House();
    }
}
