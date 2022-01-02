package item2;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * packageName : item2
 * fileName : Car
 * author : haedoang
 * date : 2022/01/02
 * description : 빌더 패턴을 적용한 Car 도메인
 */
public class Car {
    private String name;
    private BigDecimal price;

    private LocalDateTime releaseDate;
    private String option1;
    private String option2;

    public static class Builder {
        private final String name;
        private final BigDecimal price;

        private LocalDateTime releaseDate = LocalDateTime.now();
        private String option1 = "NONE";
        private String option2 = "NONE";

        public Builder(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }

        public Builder releaseDate(LocalDateTime date) {
            this.releaseDate = date;
            return this;
        }

        public Builder option1(String option1) {
            this.option1 = option1;
            return this;
        }

        public Builder option2(String option2) {
            this.option2 = option2;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public Car(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.releaseDate = builder.releaseDate;
        this.option1 = builder.option1;
        this.option2 = builder.option2;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }
}
