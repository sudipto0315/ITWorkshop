import java.util.*;

public class Q1 {

    static void ReplaceElements(int replace, ArrayList<Integer> list) {
        boolean flag = false;
        Scanner sc1 = new Scanner(System.in);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == replace) {
                flag = true;
            }
        }
        System.out.print("Enter 1 to delete only 1 occurrence and 2 to delete all occurrences: ");
        int choice = sc1.nextInt();
        int pos = 0;
        if (flag) {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, replace);
                pos = i;
            }
        } else {
            // System.out.println("Element not present in list");
        }
        if (choice == 1) {
            list.remove(pos);
        } else {
            list.clear();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int ch;
        char ans = 'y';

        while (ans == 'y' || ans == 'Y') {
            System.out.println("\n1.Add elements");
            System.out.println("2.Remove element");
            System.out.println("3.Search for element");
            System.out.println("4.Replace all elements");
            System.out.println("5.Display");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("\nEnter number of elements: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        int x;
                        System.out.print("Enter the element " + (i + 1) + ": ");
                        x = sc.nextInt();
                        list.add(x);
                    }
                    break;

                case 2:
                    int delEle, flag = 0;
                    System.out.print("Enter the element to be removed: ");
                    delEle = sc.nextInt();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) == delEle) {
                            flag++;
                            list.remove(i);
                            break;
                        } else {
                            flag = -1;
                        }
                    }
                    if (flag == -1) {
                        System.out.println("Element not present in list");
                    }
                    break;

                case 3:
                    int key;
                    flag = 0;
                    System.out.print("Enter the element to be searched: ");
                    key = sc.nextInt();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) == key) {
                            flag++;
                            System.out.println("Element found at position: " + i);
                            break;
                        } else {
                            flag = -1;
                        }
                    }
                    if (flag == -1) {
                        System.out.println("Element not present in list");
                    }
                    break;

                case 4:
                    int replace;
                    System.out.print("Enter the replace element: ");
                    replace = sc.nextInt();
                    ReplaceElements(replace, list);

                    break;

                case 5:
                    System.out.println("The array list is: ");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print(list.get(i) + " ");
                    }

                    break;

                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("\nDo you want to continue?(y/n): ");
            ans = sc.next().charAt(0);
        }
        sc.close();
    }
}
