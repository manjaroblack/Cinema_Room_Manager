import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int busHeight = scanner.nextInt();
        int numBridges = scanner.nextInt();

        for (int i = 0; i < numBridges; i++) {
            if (busHeight >= scanner.nextInt()) {
                System.out.println("Will crash on bridge " + (i + 1));
                break;
            } else if (i + 1 == numBridges) {
                System.out.println("Will not crash");
            }
        }
    }
}