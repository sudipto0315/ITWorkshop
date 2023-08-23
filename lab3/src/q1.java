import java.util.*;

public class q1 {
    static Scanner sc = new Scanner(System.in);

    static int[] mergeArray(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        int[] result = new int[size1 + size2];
        int i = 0, j = 0, k = 0;

        while (i < size1 && j < size2) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < size2) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    static int[] inputNumbers(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number at index " + i + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        int size1, size2;
        System.out.print("Enter the size of arr1: ");
        size1 = sc.nextInt();
        int arr1[] = inputNumbers(size1);

        System.out.print("Enter the size of arr2: ");
        size2 = sc.nextInt();
        int arr2[] = inputNumbers(size2);

        int[] mergedArr = mergeArray(arr1, arr2);
        System.out.println("Array after merging: ");
        for (int i = 0; i < mergedArr.length; i++) {
            System.out.print(mergedArr[i] + " ");
        }
    }
}
