import java.util.Arrays;
import java.util.Scanner;

public class q4 {
    public static void findClosestSumToZero(int[] arr) {
        Arrays.sort(arr);
        int closestSum = 0;
        int num1 = 0, num2 = 0;

        if (arr[0] >= 0) {
            closestSum = arr[0] + arr[1];
            num1 = arr[0];
            num2 = arr[1];
        } else if (arr[0] < 0) {
            int maxNegative = Integer.MIN_VALUE;
            int minPositive = Integer.MAX_VALUE;

            for (int num : arr) {
                if (num < 0 && num > maxNegative) {
                    maxNegative = num;
                }
                if (num > 0 && num < minPositive) {
                    minPositive = num;
                }
            }
            closestSum = maxNegative + minPositive;
            num1 = maxNegative;
            num2 = minPositive;
        }

        System.out.println("Closest sum to zero: " + closestSum);
        System.out.println("Numbers: " + num1 + " and " + num2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        findClosestSumToZero(arr);
    }
}
