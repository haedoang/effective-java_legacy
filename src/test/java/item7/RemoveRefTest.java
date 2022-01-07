package item7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.WeakHashMap;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : item7
 * fileName : RemoveRefTest
 * author : haedoang
 * date : 2022/01/07
 * description :
 */
public class RemoveRefTest {
    @Test
    @DisplayName("stack 구현하기")
    public void stack() {
        // given
        Stack stack = new Stack();
        String given = "hello";

        // when
        stack.push(given);

        // then
        assertThat(stack.pop()).isEqualTo(given);
    }

    @Test
    @DisplayName("pop()은 stack size 가 0인 경우 예외를 반환한다.")
    public void handlingStackError() {
        // given
        Stack stack = new Stack();

        // then
        assertThatThrownBy(stack::pop).isInstanceOf(EmptyStackException.class);
    }

    @Test
    @DisplayName("다 쓴 객체 참조는 가비지 콜렉터 대상이 되지 않고 남아있게 된다.")
    public void obsoleteReferenceTest() {
        // given
        Stack stack = new Stack();
        IntStream.range(0, 100)
                .forEach(stack::push);
        assertThat(stack.existElementsSize()).isEqualTo(100);

        // when
        IntStream.range(0, 100)
                .forEach(i -> stack.pop());
        System.gc();

        assertThat(stack.existElementsSize()).isEqualTo(100);
    }

    @Test
    @DisplayName("다 쓴 객체는 참조를 제거(null)하여야 카비지 콜렉터 수집 대상이 된다.")
    public void removeRef() {
        // given
        NewStack stack = new NewStack();

        IntStream.range(0, 100)
                .forEach(stack::push);
        assertThat(stack.existElementsSize()).isEqualTo(100);

        // when

        System.out.println(Runtime.getRuntime().freeMemory());
        IntStream.range(0, 100)
                .forEach(i -> stack.pop());
        System.gc();

        System.out.println(Runtime.getRuntime().freeMemory());

        assertThat(stack.existElementsSize()).isEqualTo(0);
    }

    @Test
    @DisplayName("WeakHashMap의 객체 참조 제거는 가비지 콜렉터의 수집 대상이 된다.")
    public void weakHashMapTest() {
        // given
        String name = new String("name");
        String email = "email";

        WeakHashMap<Object, Object> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(name, "haedoang");
        weakHashMap.put(email, "haedoang@gmail.com");

        // when
        name = null;

        System.gc();

        // then
        assertThat(weakHashMap.keySet()).hasSize(1);
    }
}
