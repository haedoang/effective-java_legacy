package item2;

import java.util.EnumSet;
import java.util.Set;

/**
 * packageName : item2
 * fileName : Hamburger
 * author : haedoang
 * date : 2022/01/02
 * description :
 */
public abstract class Hamburger {
    public enum Item {
        CHEESE,
        CHICKEN,
        SOYBEAN,
    }

    private Set<Item> items;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Item> items = EnumSet.noneOf(Item.class);

        public T addItem(Item item) {
            items.add(item);
            return self();
        }

        abstract Hamburger build();

        protected abstract T self();
    }

    Hamburger(Builder<?> builder) {
        items = builder.items.clone();
    }

    public Set<Item> getItems() {
        return items;
    }
}
