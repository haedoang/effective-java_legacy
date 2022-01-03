package item3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.CustomUtil.deserialize;
import static utils.CustomUtil.serialize;

/**
 * packageName : item3
 * fileName : PersonTest
 * author : haedoang
 * date : 2022/01/03
 * description :
 */
public class PersonTest {
    @Test
    @DisplayName("정적 멤버를 사용하여 싱글톤을 검증한다.")
    public void singletonField() {
        // given
        Person instance = Person.INSTANCE;

        // when
        Person actual = Person.INSTANCE;

        // then
        assertThat(instance).isSameAs(actual);
    }

    @Test
    @DisplayName("private 생성자를 사용할 경우 reflection 을 사용하면 싱글톤을 보장받지 못한다.")
    public void failSingletonByReflection() throws Exception {
        // given
        Person instance = Person.INSTANCE;

        // when
        Class<?> person = Class.forName("item3.Person");
        Constructor<?> personDeclaredConstructor = person.getDeclaredConstructor();
        personDeclaredConstructor.setAccessible(true);

        // then
        assertThat(instance).isNotSameAs(personDeclaredConstructor.newInstance());

    }

    @Test
    @DisplayName("싱글턴 클래스의 직렬화는 싱글턴을 보장하지 못한다.")
    public void failSingletonWhenDeserializable() throws Exception {
        // given
        Person instance = Person.INSTANCE;
        byte[] serialized = serialize(instance);

        // when
        Person actual = (Person) deserialize(serialized);

        // then
        assertThat(actual).isNotSameAs(deserialize((serialized)));
    }
}
