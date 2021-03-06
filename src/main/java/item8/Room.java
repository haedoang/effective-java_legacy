package item8;


import java.lang.ref.Cleaner;

/**
 * packageName : item8
 * fileName : Room
 * author : haedoang
 * date : 2022/01/08
 * description :
 */
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("do room clear");
            numJunkPiles = 0;
        }
    }

    private State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}
