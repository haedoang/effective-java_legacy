package item2;

/**
 * packageName : item2
 * fileName : GordonRamsayBurger
 * author : haedoang
 * date : 2022/01/02
 * description :
 */
public class GordonRamsayBurger extends Hamburger {
    private final boolean isVegan;

    public GordonRamsayBurger(Builder builder) {
        super(builder);
        this.isVegan = builder.isVegan;
    }

    public static class Builder extends Hamburger.Builder<Builder> {
        private boolean isVegan = false;

        public Builder isVegan() {
            this.isVegan = true;
            return self();
        }

        @Override
        GordonRamsayBurger build() {
            return new GordonRamsayBurger(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public boolean isVegan() {
        return isVegan;
    }
}
