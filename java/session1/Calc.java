import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = 1;

        while(x == 1) {
            System.out.println("\n=== CALCULATOR ===");
            System.out.println("1. AND");
            System.out.println("2. OR");
            System.out.println("3. NOT");
            System.out.println("4. XOR");
            System.out.println("5. NAND");
            System.out.println("6. NOR");
            System.out.println("7. Exit");
            System.out.print("Pick: ");
            int c = s.nextInt();

            if(c == 1) {
                System.out.print("A (0 or 1): ");
                int a = s.nextInt();
                System.out.print("B (0 or 1): ");
                int b = s.nextInt();
                int r = 0;
                if(a == 1 && b == 1) {
                    r = 1;
                }
                System.out.println("Result: " + r);
                System.out.println("Truth: " + a + " AND " + b + " = " + r);
            } else if(c == 2) {
                System.out.print("A (0 or 1): ");
                int a = s.nextInt();
                System.out.print("B (0 or 1): ");
                int b = s.nextInt();
                int r = 0;
                if(a == 1 || b == 1) {
                    r = 1;
                }
                System.out.println("Result: " + r);
                System.out.println("Truth: " + a + " OR " + b + " = " + r);
            } else if(c == 3) {
                System.out.print("A (0 or 1): ");
                int a = s.nextInt();
                int r = 0;
                if(a == 0) {
                    r = 1;
                } else {
                    r = 0;
                }
                System.out.println("Result: " + r);
                System.out.println("Truth: NOT " + a + " = " + r);
            } else if(c == 4) {
                System.out.print("A (0 or 1): ");
                int a = s.nextInt();
                System.out.print("B (0 or 1): ");
                int b = s.nextInt();
                int r = 0;
                if(a != b) {
                    r = 1;
                }
                System.out.println("Result: " + r);
                System.out.println("Truth: " + a + " XOR " + b + " = " + r);
            } else if(c == 5) {
                System.out.print("A (0 or 1): ");
                int a = s.nextInt();
                System.out.print("B (0 or 1): ");
                int b = s.nextInt();
                int r = 1;
                if(a == 1 && b == 1) {
                    r = 0;
                }
                System.out.println("Result: " + r);
                System.out.println("Truth: " + a + " NAND " + b + " = " + r);
            } else if(c == 6) {
                System.out.print("A (0 or 1): ");
                int a = s.nextInt();
                System.out.print("B (0 or 1): ");
                int b = s.nextInt();
                int r = 1;
                if(a == 1 || b == 1) {
                    r = 0;
                }
                System.out.println("Result: " + r);
                System.out.println("Truth: " + a + " NOR " + b + " = " + r);
            } else if(c == 7) {
                System.out.println("Goodbye!");
                x = 0;
            } else {
                System.out.println("Invalid!");
            }
        }
        s.close();
    }
}