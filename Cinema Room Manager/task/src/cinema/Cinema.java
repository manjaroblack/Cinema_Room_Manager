package cinema;

import java.util.Scanner;

public class Cinema {
    final private static Scanner scanner = new Scanner(System.in);
    private static int rows, seats, numTickets, income, maxIncome;
    private static String[][] cinema;

    public static void initializeCinema(){
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        maxIncome = rows * seats <= 60 ? rows * seats :
                (rows / 2) * 10 * seats + (rows - rows / 2) * 8 * seats;
        cinema = new String[rows + 1][seats + 1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                cinema[i][j] = i == 0 ?
                        String.valueOf(j) :
                        j == 0 ? String.valueOf(i) : "S";
            }
        }
        cinema[0][0] = "  ";
    }

    public static int menu() {
        System.out.println(
            "1. Show the seats\n" +
            "2. Buy a ticket\n" +
            "3. Statistics\n" +
            "0. Exit");
        return scanner.nextInt();
    }

    public static void printSeats() {
        System.out.println("Cinema:\n" +
                java.util.Arrays.deepToString(cinema)
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "\n"));
    }

    public static void buyTicket() {
        System.out.println("Enter a row number:");
        int rowNum = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNum = scanner.nextInt();

        if (rowNum > rows || seatNum > seats) {
            System.out.println("Wrong input!");
            buyTicket();
        } else if (cinema[rowNum][seatNum].equals("B")) {
            System.out.println("That ticket has already been purchased!");
            buyTicket();
        } else {
            if (rows * seats <= 60 || rowNum <= rows / 2) {
                System.out.println("Ticket price: $10");
                income += 10;
            } else {
                System.out.println("Ticket price: $8");
                income += 8;
            }
            cinema[rowNum][seatNum] = "B";
            numTickets += 1;
        }
    }

    public static void printStatistics() {
        System.out.printf("Number of purchased tickets: %d%n" +
                "Percentage: %.2f%" + "%%n" +
                "Current income: $%d%n" +
                "Total income: $%d%n",
                numTickets, numTickets*100.0/(rows*seats), income, maxIncome);
    }

    public static void main(String[] args) {
        income = 0;
        numTickets = 0;
        initializeCinema();
        for (boolean a = true; a;) {
            switch (menu()) {
                case 0:
                    a = false;
                    break;
                case 1:
                    printSeats();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    printStatistics();
                    break;
                default:
                    break;
            }
        }
    }
}