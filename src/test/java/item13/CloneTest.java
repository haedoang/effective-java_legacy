package item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : item13
 * fileName : PersonTest
 * author : haedoang
 * date : 2022-01-13
 * description :
 */
@DisplayName("Clone 테스트")
class CloneTest {

    @Test
    @DisplayName("cloneable 객체 테스트")
    public void cloneable() throws CloneNotSupportedException {
        // given
        Person person = new Person("haedoang", 34);

        // when 
        Person clone = (Person) person.clone();

        // then
        assertThat(person).isEqualTo(clone);
        assertThat(person.clone() != person).isTrue().as("clone 객체는 서로 다른 참조 메모리를 가진다.");
        assertThat(person.clone().getClass() == person.getClass()).isTrue();
    }

    @Test
    @DisplayName("Cloneable 객체가 아닌 경우 예외가 발생한다.")
    public void cloneNotAccepted() {
        // given
        Pet pet = new Pet("Jerry", 15);

        // then
        assertThatThrownBy(pet::clone).isInstanceOf(CloneNotSupportedException.class);
    }


    @Test
    @DisplayName("상속관계에서의 clone")
    public void superClassClone() throws CloneNotSupportedException {
        // given
        KoreanPerson koreanPerson = new KoreanPerson("haedongkim", 34);

        // when
        Object clone = koreanPerson.clone();

        // then
        assertThat(clone.getClass()).isEqualTo(koreanPerson.getClass());
    }


    @Test
    @DisplayName("불변식을 해치는 clone")
    public void cloneStack() throws CloneNotSupportedException {
        // given
        Stack original = new Stack();
        original.push("hello");
        assertThat(original.existElementsSize()).isEqualTo(1);

        // when
        Stack clone = (Stack) original.clone();
        clone.push("same array");

        // then
        assertThat(original.existElementsSize()).isEqualTo(clone.existElementsSize())
                .as("배열의 clone은 원본 배열과 같은 타입을 반환한다");
        assertThat(original.elementsHashcode()).isEqualTo(clone.elementsHashcode());
    }


    @Test
    @DisplayName("가변상태를 참조하는 클래스의 clone")
    public void refactorCloneStack() {
        // given
        Stack original = new Stack();
        original.push("hello");
        assertThat(original.existElementsSize()).isEqualTo(1);

        // when
        Stack clone = (Stack) original.refactorClone();
        clone.push("not same array");

        // then
        assertThat(original.existElementsSize()).isLessThan(clone.existElementsSize());
        assertThat(original.elementsHashcode()).isNotEqualTo(clone.elementsHashcode());
    }

    //TODO LinkedList Test


    class Stack implements Cloneable {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object obj) {
            ensureCapacity();
            elements[size++] = obj;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            return elements[--size];
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }

        public int existElementsSize() {
            return (int) Arrays.stream(elements).filter(Objects::nonNull).count();
        }

        public int elementsHashcode() {
            return elements.hashCode();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public Object refactorClone() {
            try {
                Stack result = (Stack) super.clone();
                result.elements = elements.clone();
                return result;
            } catch(CloneNotSupportedException c) {
                throw new AssertionError();
            }
        }
    }

}
