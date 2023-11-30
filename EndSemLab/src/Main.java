import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Employee implements Serializable {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class TempEmployee extends Employee {
    TempEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    void display() {
        System.out.println("Temporary Employee:");
        super.display();
    }
}

class PermanentEmployee extends Employee {
    PermanentEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    void display() {
        System.out.println("Permanent Employee:");
        super.display();
    }
}

class Server {
    private ArrayList<Employee> employees;

    Server(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    void serializeEmployees() {
        try {
            FileOutputStream fileOut = new FileOutputStream("employees.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employees);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    void deserializeEmployees() {
        try {
            FileInputStream fileIn = new FileInputStream("employees.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            employees = (ArrayList<Employee>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
    }

    int getTotalEmployees() {
        return employees.size();
    }

    Employee getEmployeeDetails(int id) {
        return employees.stream().filter(e -> e.id == id).findFirst().orElse(null);
    }

    Employee getEmployeeWithHigherSalary(int id1, int id2) {
        Employee e1 = getEmployeeDetails(id1);
        Employee e2 = getEmployeeDetails(id2);
        return (e1.salary > e2.salary) ? e1 : e2;
    }
}

class Client {
    private Server server;

    Client(Server server) {
        this.server = server;
    }

    void requestTotalEmployees() {
        System.out.println("Total employees: " + server.getTotalEmployees());
    }

    void requestEmployeeDetails(int id) {
        Employee e = server.getEmployeeDetails(id);
        if (e != null) {
            e.display();
        } else {
            System.out.println("No employee found with ID: " + id);
        }
    }

    void requestEmployeeWithHigherSalary(int id1, int id2) {
        Employee e = server.getEmployeeWithHigherSalary(id1, id2);
        if (e != null) {
            e.display();
        } else {
            System.out.println("No employees found with IDs: " + id1 + ", " + id2);
        }
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        System.out.print("Enter No of Employees (Size Of ArrayList): ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            System.out.print("Is this a permanent employee? (y/n): ");
            String isPermanent = sc.next();
            if (isPermanent.equalsIgnoreCase("y")) {
                employees.add(new PermanentEmployee(id, name, salary));
            } else {
                employees.add(new TempEmployee(id, name, salary));
            }
        }

        Server server = new Server(employees);
        server.serializeEmployees();

        Client client = new Client(server);

        System.out.println("Total Number of Employees: ");
        client.requestTotalEmployees();
        System.out.println();
        System.out.print("Enter Employee ID for fetching the details: ");
        int EmpID = sc.nextInt();
        client.requestEmployeeDetails(EmpID);
        System.out.println();
        System.out.println("Employee with higher salary: ");
        System.out.println();
        System.out.println("Enter Employee ID's to Compare: ");
        System.out.print("ID 1: ");
        int EmpID1 = sc.nextInt();
        System.out.print("ID 2: ");
        int EmpID2 = sc.nextInt();
        client.requestEmployeeWithHigherSalary(EmpID1, EmpID2);
    }
}