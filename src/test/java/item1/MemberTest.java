package item1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * packageName : domain
 * fileName : MemberTest
 * author : haedoang
 * date : 2022/01/01
 * description : 정적 팩토리 메서드 패턴에 대해 학습에 초점을 맞춘 클래스와 메서드임을 참고할 것
 */
@DisplayName("정적 팩토리 메서드 작성하기")
public class MemberTest {
    @Test
    @DisplayName("from : 매개변수를 하나 받아 해당 타입의 인스턴스를 반화하는 형 변환 메서드")
    public void from() {
        // given
        String name = "찰스";

        // when
        MaleMember actual = MaleMember.from(name);

        // then
        assertThat(actual.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("of : 여러개의 매개변수를 받아 적합한 타입의 인스턴스르 반환하는 집계 메서드")
    public void of() {
        // given
        String name = "찰스";
        int age = 34;

        // when
        MaleMember actual = MaleMember.of(name, age);

        // then
        assertAll(
                () -> assertThat(actual.getName()).isEqualTo(name),
                () -> assertThat(actual.getAge()).isEqualTo(age)
        );
    }

    @Test
    @DisplayName("valueOf : from 과 of의 더 자세한 버전")
    public void valueOf() {
        // given
        String name = "찰스";
        int age = 34;

        // when
        MaleMember actual = MaleMember.valueOf(name, age);

        // then
        assertAll(
                () -> assertThat(actual.getName()).isEqualTo(name),
                () -> assertThat(actual.getAge()).isEqualTo(age)
        );
    }

    @Test
    @DisplayName("instance, getInstance :  인스턴스를 반환하지만, 같은 인스턴스를 보장하지 않을 때 사용한다.")
    public void getInstance() {
        // when
        MaleMember actual = MaleMember.getInstance();

        // then
        assertThat(actual).isNotNull();
    }

    @Test
    @DisplayName("create, newInstance : 인스턴스를 반환하지만, 매번 새로운 인스턴스를 반환할 때 사용한다.")
    public void newInstance() throws Exception {
        // when
        MaleMember actual = MaleMember.newInstance();

        // then
        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).isNotSameAs(MaleMember.newInstance())
        );
    }

    @Test
    @DisplayName("getType : getInstance 와 같으나 생성할 클래스가 아닌 다른 클래스 팩터리 메서드를 정의할 때 사용한다.")
    public void getType() {
        // when
        House actual = MaleMember.getHouse();

        // then
        assertThat(actual).isNotNull();
    }

    @Test
    @DisplayName("newType :  newInstance 와 같으나 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 떄 쓴다.")
    public void newType() {
        // when
        House actual = MaleMember.newHouse();

        // then
        assertThat(actual).isNotSameAs(MaleMember.newHouse());
    }

    @Test
    @DisplayName("type : getType 과 newType 의 간결한 버전")
    public void type() {
        // when
        List<MaleMember> actual = MaleMember.list();

        // then
        assertThat(actual).isInstanceOf(List.class);
    }
}
