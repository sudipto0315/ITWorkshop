import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        if (n < 3) {
            System.out.println("Array should have at least 3 elements.");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int thirdLargest = findThirdLargest(arr);

        if (thirdLargest != Integer.MIN_VALUE) {
            System.out.println("The third largest element is: " + thirdLargest);
        } else {
            System.out.println("Array doesn't have a third largest element.");
        }

        scanner.close();
    }

    public static int findThirdLargest(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return Integer.MIN_VALUE;
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax && arr[i] != firstMax) {
                thirdMax = secondMax;
                secondMax = arr[i];
            } else if (arr[i] > thirdMax && arr[i] != firstMax && arr[i] != secondMax) {
                thirdMax = arr[i];
            }
        }

        return thirdMax;
    }
}
