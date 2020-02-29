import java.util.Random;

public class IneffectiveCase {
    public static void main (String[] args){
        int i = new Random().nextInt();

        if (i >= 1000) {
            if (i <= 1000) {
                throw new AssertionError("cant touch this");
            }
        }
        throw new AssertionError("can touch this");
    }
}
