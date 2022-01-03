package item3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.CustomUtil.deserialize;
import static utils.CustomUtil.serialize;

/**
 * packageName : item3
 * fileName : PersonTest
 * author : haedoang
 * date : 2022/01/03
 * description : 싱글턴을 보증하는 도메인 테스트
 */
class PetTest {
    @Test
    @DisplayName("정적 팩토리 메서드의 싱글톤을 검증한다.")
    public void singletonFactoryMethod() {
        // given
        Pet instance = Pet.getInstance();

        // when
        Pet actual = Pet.getInstance();

        // then
        assertThat(instance).isSameAs(actual);
    }


    @Test
    @DisplayName("readResolve 메소드로 싱글톤을 보장할 수 있다.")
    public void singletonWhenDeserializable() throws Exception {
        // given
        Pet pet = Pet.getInstance();
        byte[] serialized = serialize(pet);

        // when
        Pet deserialize = (Pet) deserialize(serialized);

        // then
        assertThat(deserialize).isSameAs(deserialize(serialized));
    }
}