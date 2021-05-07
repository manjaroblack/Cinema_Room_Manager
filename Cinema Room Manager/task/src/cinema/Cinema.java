package cinema;

public class Cinema {

    public static void printSeats(String[][] cinema) {
        System.out.println("Cinema:\n" +
                java.util.Arrays.deepToString(cinema)
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "\n"));
    }

    public static int menu() {
        System.out.println(
                "1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit");
        return new java.util.Scanner(System.in).nextInt();
    }

    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        String[][] cinema = new String[rows + 1][seats + 1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                cinema[i][j] = i == 0 ?
                        String.valueOf(j) :
                        j == 0 ? String.valueOf(i) : "S";
            }
        }
        cinema[0][0] = "  ";

        for (boolean a = true; a;) {
            switch (menu()) {
                case 0:
                    a = false;
                    break;
                case 1:
                    printSeats(cinema);
                    break;
                case 2:
                    System.out.println("Enter a row number:");
                    int rowNum = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seatNum = scanner.nextInt();
                    System.out.println("Ticket Price: $" + (rows * seats <= 60 || rowNum <= rows / 2 ? 10 : 8));
                    cinema[rowNum][seatNum] = "B";
                    printSeats(cinema);
                    break;
                default:
                    break;
            }
        }
    }
}