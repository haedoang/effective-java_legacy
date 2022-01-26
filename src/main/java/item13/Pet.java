package item13;

/**
 * packageName : item13
 * fileName : Pet
 * author : haedoang
 * date : 2022-01-13
 * description : Clone 객체가 아닌 클래스
 */
public class Pet {
    private final String name;
    private final int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
