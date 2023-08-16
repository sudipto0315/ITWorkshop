import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0, size;
        System.out.print("Enter the size of the array: ");
        size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the " + i + " element: ");
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            result += arr[i];
        }
        System.out.println("The sum of the elements is: " + result);
        sc.close();
    }
}
