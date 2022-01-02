package item2;

import java.util.Objects;

import static java.util.Objects.*;

/**
 * packageName : item2
 * fileName : MomsTouchBurger
 * author : haedoang
 * date : 2022/01/02
 * description :
 */
public class MomsTouchBurger extends Hamburger {
    public enum Size { SMALL, LARGE }
    private final Size size;

    public MomsTouchBurger(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static class Builder extends Hamburger.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = requireNonNull(size);
        }

        @Override
        MomsTouchBurger build() {
            return new MomsTouchBurger(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public Size getSize() {
        return size;
    }
}
