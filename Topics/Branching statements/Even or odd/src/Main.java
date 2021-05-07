import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        while (number != 0) {
            System.out.println(number % 2 == 0 ? "even" : "odd");
            number = scanner.nextInt();
        }
    }
}