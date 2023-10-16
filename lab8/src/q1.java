import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student>{
    String name;
    int roll;
    String birthyear;

    public Student() {
        name = "";
        roll = 0;
        birthyear = "";
    }

    public Student(String name, int roll, String birthyear) {
        this.name = name;
        this.roll = roll;
        this.birthyear = birthyear;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public String getBirthyear() {
        return birthyear;
    }

    @Override
    public int compareTo(Student that) {
        return this.name.split(" ")[0].compareTo(that.name.split(" ")[0]);
    }

    public int compareByTitle(Student that) {
        return this.name.split(" ")[1].compareTo(that.name.split(" ")[1]);
    }

    public int compareByRoll(Student that) {
        if (this.roll > that.roll)
            return -1;
        else if (this.roll < that.roll)
            return 1;
        else
            return 0;
    }

    public int compareByBirthyear(Student that) {
        return this.birthyear.compareTo(that.birthyear);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                ", birthyear='" + birthyear + '\'' +
                '}';
    }
}

public class q1 {
    static Scanner sc = new Scanner(System.in);

    private static void printStudentList(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Student> stu = new ArrayList<>();

//sample input
//        stu.add(new Student("Sudipto Ray", 1, "2003"));
//        stu.add(new Student("Souradip Saha", 2, "2002"));
//        stu.add(new Student("Sreejita Das", 3, "2004"));
//        stu.add(new Student("Soumya Mitra", 4, "2005"));
//        stu.add(new Student("Dinakar Maruti", 5, "2006"));

//user input
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter student " + i + " information:");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Birthyear: ");
            String birthyear = sc.nextLine();

            stu.add(new Student(name, roll, birthyear));
        }

        // Display the student list
        System.out.println("Student List:");
        printStudentList(stu);

//Using Comparable
        Collections.sort(stu,Student::compareTo);
        System.out.println("\nStudents sorted with respect to first name:");
        printStudentList(stu);

        Collections.sort(stu,Student::compareByTitle);

        System.out.println("\nStudents sorted with respect to title:");
        printStudentList(stu);

        stu.sort(Student::compareByRoll);
        System.out.println("\nStudents sorted with respect to roll number:");
        printStudentList(stu);

        stu.sort(Student::compareByBirthyear);
        System.out.println("\nStudents sorted with respect to birth year:");
        printStudentList(stu);

//Using Comparator
        //NameComparator
//        System.out.println("NameComparator");
//        Collections.sort(stu, new NameComparator());
//        printStudentList(stu);

        //TitleComparator
//        System.out.println("TitleComparator");
//        Collections.sort(stu, new TitleComparator());
//        printStudentList(stu);

        //RollComparator
//        System.out.println("RollComparator");
//        Collections.sort(stu, new RollComparator());
//        printStudentList(stu);

        //BirthYearComparator
//        System.out.println("BirthYearComparator");
//        Collections.sort(stu, new BirthYearComparator());
//        printStudentList(stu);
    }
}
