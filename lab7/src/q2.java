import java.util.Scanner;

class Person {
    int age;
    public  Person(){
        int age = 0;
    }
    public Person(int age) {
        this.age = age;
    }

    void eat() {
        System.out.println("Person is eating.");
    }

    void sleep() {
        System.out.println("Person is sleeping.");
    }
}

interface Driver {
    int driveCar();
    int driveBike();
}

interface Singer {
    int sing();
    void riyaz();
}

class Employee extends Person implements Driver, Singer {
    public Employee(int age) {
        super(age);
    }

    @Override
    public int driveCar() {
        int carDrivingScore = (age < 40) ? 10 : 0;
        System.out.println("Employee is driving a car with a score of " + carDrivingScore);
        return carDrivingScore;
    }

    @Override
    public int driveBike() {
        int bikeDrivingScore = (age < 40) ? 5 : 0;
        System.out.println("Employee is driving a bike with a score of " + bikeDrivingScore);
        return bikeDrivingScore;
    }

    // Implementing the Singer interface
    @Override
    public int sing() {
        int singingScore = (age < 20) ? 15 : 0;
        System.out.println("Employee is singing with a score of " + singingScore);
        return singingScore;
    }

    @Override
    public void riyaz() {
        System.out.println("Employee is doing riyaz.");
    }

    // New function defined in the Employee class
    int officeWork() {
        int officeWorkScore = (age < 40) ? 20 : 10;
        System.out.println("Employee is doing office work with a score of " + officeWorkScore);
        return officeWorkScore;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        Employee employee = new Employee(age);

        System.out.println("Choose an action:");
        System.out.println("1. Employee acting as a Driver");
        System.out.println("2. Employee acting as a Singer");
        System.out.println("3. Employee doing office work");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Scenario (a): Employee acting as a Driver
                employee.driveCar();
                employee.driveBike();
                // Cannot access Singer related functions
                // employee.sing();
                // employee.riyaz();
                break;
            case 2:
                // Scenario (b): Employee acting as a Singer
                employee.sing();
                employee.riyaz();
                // Cannot access Driver related functions
                // employee.driveCar();
                // employee.driveBike();
                break;
            case 3:
                // Demonstrate the officeWork() function
                employee.officeWork();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }
}
