package item8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : item8
 * fileName : RoomTest
 * author : haedoang
 * date : 2022/01/08
 * description :
 */
class Adult {
    public static void main(String[] args) {
        try (Room room = new Room(7)) {
            System.out.println("try with resource 를 통해 객체를 수거한다.");
        }
    }
}