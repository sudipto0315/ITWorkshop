import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element #" + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int smallest = findSmallestElement(arr);

        System.out.println("The smallest element in the array is: " + smallest);

        scanner.close();
    }

    public static int findSmallestElement(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array should not be empty.");
        }

        int smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        return smallest;
    }
}
