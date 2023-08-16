import java.util.Scanner;

public class q5 {

    // Method to take a series of numbers as input and store in an array
    static int[] inputNumbers(int size) {
        Scanner scanner = new Scanner(System.in);
        int array[] = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter number at index " + i + ": ");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    // Method to reverse the elements of an array
    static void reverseArray(int array[]) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int numbers[] = inputNumbers(size);

        System.out.println("Original array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        reverseArray(numbers);

        System.out.println("Reversed array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
