class Main {
    public static void main(String[] args) {
        var s = new java.util.Scanner(System.in);
        boolean asc = true;
        boolean desc = true;
        for (int b, a = s.nextInt(); (b = s.nextInt()) != 0; a = b) {
            asc &= a <= b;
            desc &= a >= b;
        } System.out.println(asc || desc);
    }
}