package item7;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

/**
 * packageName : item7
 * fileName : Stack
 * author : haedoang
 * date : 2022/01/07
 * description :
 */
public class Stack {
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


}
