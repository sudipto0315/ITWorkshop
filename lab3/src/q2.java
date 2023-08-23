import java.util.Scanner;
public class q2 {
    public static int[] findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        int commonCount = 0;
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                commonCount++;
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        int[] resultArray = new int[commonCount];
        commonCount = 0;
        i = 0;
        j = 0;
        k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                resultArray[commonCount] = arr1[i];
                commonCount++;
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        return resultArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the first array: ");
        int length1 = scanner.nextInt();
        int[] arr1 = new int[length1];
        System.out.println("Enter the elements of the first array in sorted order:");
        for (int i = 0; i < length1; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter the length of the second array: ");
        int length2 = scanner.nextInt();
        int[] arr2 = new int[length2];
        System.out.println("Enter the elements of the second array in sorted order:");
        for (int i = 0; i < length2; i++) {
            arr2[i] = scanner.nextInt();
        }

        System.out.print("Enter the length of the third array: ");
        int length3 = scanner.nextInt();
        int[] arr3 = new int[length3];
        System.out.println("Enter the elements of the third array in sorted order:");
        for (int i = 0; i < length3; i++) {
            arr3[i] = scanner.nextInt();
        }

        int[] resultArray = findCommonElements(arr1, arr2, arr3);

        System.out.println("The Common elements are: ");
        for (int num : resultArray) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        System.out.print("Enter the value of K: ");
        int k = scanner.nextInt();
        System.out.println("The Kth smallest element is: "+resultArray[k+1]);
        scanner.close();
    }
}
