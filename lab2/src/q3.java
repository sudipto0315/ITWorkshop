import java.util.Scanner;

class q3 {
    static Scanner sc = new Scanner(System.in);

    static void palindrome(int arr[], int n) {
        // Initialise flag to zero.
        int flag = 0;
        // Loop till array size n/2.
        for (int i = 0; i <= n / 2 && n != 0; i++) {
            // Check if first and last element are different
            // Then set flag to 1.
            if (arr[i] != arr[n - i - 1]) {
                flag = 1;
                break;
            }
        }
        // If flag is set then print Not Palindrome
        // else print Palindrome.
        if (flag == 1) System.out.println("The entred array is Not Palindrome");
        else System.out.println("The entred array is Palindrome");
    }

    // Driver code.
    public static void main(String[] args) {
        System.out.print("Enter the size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + i + " element: ");
            arr[i] = sc.nextInt();
        }
        palindrome(arr, n);
    }
}
