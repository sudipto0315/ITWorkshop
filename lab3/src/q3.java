import java.util.Scanner;
public class q3 {
    public static void pushCharacterToEnd(char[] arr, char k) {
        int occurences = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != k) {
                arr[occurences] = arr[i];
                occurences++;
            }
        }

        while (occurences < arr.length) {
            arr[occurences] = k;
            occurences++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the character array
        System.out.print("Enter the length of the character array: ");
        int length = scanner.nextInt();
        char[] charArray = new char[length];

        System.out.println("Enter the character array:");
        for (int i = 0; i < length; i++) {
            charArray[i] = scanner.next().charAt(0);
        }

        // Input the character to be pushed to the end
        System.out.print("Enter the character to push to the end: ");
        char k = scanner.next().charAt(0);

        // Close the scanner
        scanner.close();

        pushCharacterToEnd(charArray, k);

        // Print the modified character array
        System.out.println("Modified character array:");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
    }
}
