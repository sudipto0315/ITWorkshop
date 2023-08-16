import java.util.Scanner;

public class q4 {
    static void checkDivisible(int n1, int n2) {
        if (n2 != 0) {
            if (n1 % n2 == 0) {
                System.out.println("The first number is divisible by the second number.");
            } else {
                System.out.println("The first number is not divisible by the second number.");
            }
        } else {
            System.out.println("Cannot divide by zero.");
        }
    }

    static void checkTernary(int n1, int n2) {
        String result = (n2 != 0)
                ? (n1 % n2 == 0) ? "The first number is divisible by the second number."
                : "The first number is not divisible by the second number."
                : "Cannot divide by zero.";
        System.out.println(result);
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the First number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter the Second number: ");
        int n2 = sc.nextInt();
        System.out.print("\n");
        System.out.println("Using if statement: ");
        checkDivisible(n1, n2);
        System.out.println("Using ternary operator: ");
        checkTernary(n1, n2);
    }
}
