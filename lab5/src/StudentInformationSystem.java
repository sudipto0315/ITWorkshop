import java.util.Scanner;

class Student {
    static Scanner sc = new Scanner(System.in);
    int studentID;
    String studentName;
    int studentAge;
    String studentMajor;
    float studentGPA;
    static int totalStudentsEnrolled;

    Student() {
        studentID = 0;
        studentName = "";
        studentAge = 0;
        studentMajor = "";
        studentGPA = 0.0f;
        totalStudentsEnrolled = 0;
    }

    public void setDetails(int id, String name, int age, String major, float GPA) {
        studentID = id;
        studentName = name;
        studentAge = age;
        studentMajor = major;
        studentGPA = GPA;
        totalStudentsEnrolled = totalStudentsEnrolled + 1;
    }

    public void getDetails(int id) {
        System.out.println("Student ID = " + id);
        System.out.println("Student Name = " + studentName);
        System.out.println("Student Age = " + studentAge);
        System.out.println("Student Major = " + studentMajor);
        System.out.println("Student GPA = " + studentGPA);
    }

    public void updateDetails(int id) {
        String name;
        int age;
        String major;
        float GPA;
        System.out.print("Enter the updated Student ID: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the updated Student Name: ");
        name = sc.nextLine();
        System.out.print("Enter the updated Student Age: ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the updated Student Major: ");
        major = sc.nextLine();
        System.out.print("Enter the updated Student GPA: ");
        GPA = sc.nextFloat();
        setDetails(id, name, age, major, GPA);
    }

    public float getGPA(int id) {
        return studentGPA;
    }

    public void updateGPA(int id, float newGPA) {
        studentGPA = newGPA;
    }

    static int totalStudents() {
        return totalStudentsEnrolled;
    }
}

public class StudentInformationSystem {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the number of objects: ");
        int size = sc.nextInt();
        Student[] stuObj = new Student[size];
        int id, age;
        float GPA;
        String name, major;
        for (int i = 0; i < stuObj.length; i++) {
            stuObj[i] = new Student();
            System.out.println("\nFor student " + (i + 1) + ": ");
            System.out.print("Enter the Student ID: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the Student Name: ");
            name = sc.nextLine();
            System.out.print("Enter the Student Age: ");
            age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the Student Major: ");
            major = sc.nextLine();
            System.out.print("Enter the Student GPA: ");
            GPA = sc.nextFloat();
            stuObj[i].setDetails(id, name, age, major, GPA);
        }
        char ans = 'Y';
        int ch;
        while (ans == 'Y' || ans == 'y') {
            System.out.println("\n");
            System.out.println("1.Update Student Details");
            System.out.println("2.Get Student Details");
            System.out.println("3.Update Student GPA");
            System.out.println("4.Get Total Students");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("\nEnter the required Student ID: ");
                    int id1 = sc.nextInt();
                    for (int i = 0; i < stuObj.length; i++) {
                        if (stuObj[i].studentID == id1) {
                            stuObj[i].updateDetails(id1);
                        }
                    }
                    System.out.println("Student Details Were Updated!");
                    break;
                case 2:
                    System.out.println("\nEnter the required Student ID: ");
                    int id2 = sc.nextInt();
                    for (int i = 0; i < stuObj.length; i++) {
                        if (stuObj[i].studentID == id2) {
                            System.out.println("Student Details Are: ");
                            stuObj[i].getDetails(id2);
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nEnter the required Student ID: ");
                    int id3 = sc.nextInt();
                    float newGPA = 0.0f;
                    for (int i = 0; i < stuObj.length; i++) {
                        if (stuObj[i].studentID == id3) {
                            System.out.print("Enter the updated GPA: ");
                            newGPA = sc.nextFloat();
                            stuObj[i].updateGPA(id3, newGPA);
                        }
                    }
                    System.out.print("The Updated Student GPA Is: ");
                    for (int i = 0; i < stuObj.length; i++) {
                        if (stuObj[i].studentID == id3) {
                            System.out.print(stuObj[i].getGPA(id3)+"\n");
                        }
                    }
                    break;
                case 4:
                int totalStudents=Student.totalStudents();
                System.out.println("Total No of Students Are: "+totalStudents);
                    break;
                case 5:
                    System.out.println("Exit from system");
                    break;

                default:
                    System.out.println("Invalid choice, try again");
            }
            System.out.print("Do you want to continue(y/n)? ");
            ans = sc.next().charAt(0);
        }
    }

}
