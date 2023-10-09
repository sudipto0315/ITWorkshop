import java.util.Scanner;
class q3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter age for Employee " + (i + 1) + ": ");
            int age = sc.nextInt();
            employees[i] = new Employee(age);
        }
        int[] eifs = new int[5];
        for (int i = 0; i < 5; i++) {
            eifs[i] = employees[i].driveCar() + employees[i].driveBike() + employees[i].sing() + employees[i].officeWork();
        }
        sort(employees, eifs);
        // Print the sorted employees and EIF values
        System.out.println("Employees sorted by EIF:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Age: " + employees[i].age + ", EIF: " + eifs[i]);
        }
    }
    // Sort employees based on EIF values using insertion sort
    static void sort(Employee[] employees, int[] eifs) {
        int n = employees.length;

        for (int i = 1; i < n; i++) {
            Employee currentEmployee = employees[i];
            int currentEIF = eifs[i];
            int j = i - 1;

            while (j >= 0 && eifs[j] > currentEIF) {
                employees[j + 1] = employees[j];
                eifs[j + 1] = eifs[j];
                j--;
            }

            employees[j + 1] = currentEmployee;
            eifs[j + 1] = currentEIF;
        }
    }
}