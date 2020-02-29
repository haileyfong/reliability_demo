public class RaceCondition {
    static int expectedCount = 1000;
    static int currentCount = 0;
    public static void main(String[] args) {
        Runnable adder = () -> {
            for(int i = 0; i < 500; i++) {
                currentCount++;
            }
        };

        new Thread(adder).start();
        new Thread(adder).start();

        assert currentCount == expectedCount;

    }
}
