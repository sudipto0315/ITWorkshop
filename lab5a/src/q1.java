import java.util.Scanner;

public class q1 {
    static Scanner sc = new Scanner(System.in);

    static int[] inputNumbers(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element #" + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        int size,sum=0;
        System.out.print("Enter the size of arr1: ");
        size = sc.nextInt();
        int arr[] = inputNumbers(size);
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        int avg=(int)sum/arr.length;
        System.out.println("The average is: "+avg);
        System.out.println("The sum of the elements are: "+sum);
    }
}
