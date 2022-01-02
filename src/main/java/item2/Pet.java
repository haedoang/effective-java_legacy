package item2;

/**
 * packageName : item2
 * fileName : Pet
 * author : haedoang
 * date : 2022/01/02
 * description : 자바빈즈 패턴 도메인, 기본생성자를 사용하며 필드의 값을 세터메서드를 통해 값을 설정한다.
 */
public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
