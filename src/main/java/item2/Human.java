package item2;

/**
 * packageName : item2
 * fileName : Human
 * author : haedoang
 * date : 2022/01/02
 * description : 점층적 생성자 패턴 도메인 (예시를 위해 생성자를 2개로 구분하였다)
 */
public class Human {
    private String firstName;
    private String middleName;
    private String lastName;

    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Human(String firstName, String middleName, String lastName, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
