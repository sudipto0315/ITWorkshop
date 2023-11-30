import java.util.Scanner;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String s) {
        super(s);
    }
}

class InvalidPINException extends Exception {
    public InvalidPINException(String s) {
        super(s);
    }
}

class InvalidRollNumberException extends Exception {
    public InvalidRollNumberException(String s) {
        super(s);
    }
}

class InvalidEmployeeIdException extends Exception {
    public InvalidEmployeeIdException(String s) {
        super(s);
    }
}

class Person {
    String firstName;
    String lastName;
    String pan;
    String address;
    int pin;

    Person(String firstName, String lastName, String pan, String address, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pan = pan;
        this.address = address;
        this.pin = pin;
        try {
            validate();
        } catch (InvalidPINException e) {
            System.out.println(e.getMessage());
        }
    }

    void validate() throws InvalidPINException {
        if (pin <= 99999 || pin >= 1000000) {
            throw new InvalidPINException("Invalid PIN Code");
        }
    }
}

class Student extends Person {
    String emailId;
    String rollNumber;

    Student(String firstName, String lastName, String pan, String address, int pin, String emailId, String rollNumber) {
        super(firstName, lastName, pan, address, pin);
        this.emailId = emailId;
        this.rollNumber = rollNumber;
        try {
            validate();
        } catch (InvalidEmailException | InvalidRollNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    void validate() throws InvalidEmailException, InvalidRollNumberException {
        super.validate();

        boolean isValid = true;
        int atIndex = -1;
        int splCharIndex = -1;

        for (int i = 0; i < emailId.length(); i++) {
            char ch = emailId.charAt(i);

            if (i == 0 && !Character.isLetterOrDigit(ch)) {
                isValid = false;
                break;
            }

            if (ch == '@') {
                atIndex = i;
            } else if (!Character.isLetterOrDigit(ch) && ch != '.' && ch != '_') {
                splCharIndex = i;
            }
        }

        if (atIndex == -1 || splCharIndex == -1 || splCharIndex > atIndex) {
            isValid = false;
        }

        if (!isValid) {
            throw new InvalidEmailException("Invalid email");
        }

        if (!rollNumber.startsWith("stud") || rollNumber.length() != 10) {
            throw new InvalidRollNumberException("Invalid roll number");
        }

        for (int i = 4; i < rollNumber.length(); i++) {
            if (!Character.isDigit(rollNumber.charAt(i))) {
                throw new InvalidRollNumberException("Invalid roll number");
            }
        }
    }
}

class Employee extends Person {
    String emailId;
    String employeeId;

    Employee(String firstName, String lastName, String pan, String address, int pin, String emailId, String employeeId) {
        super(firstName, lastName, pan, address, pin);
        this.emailId = emailId;
        this.employeeId = employeeId;
        try {
            validate();
        } catch (InvalidEmailException | InvalidEmployeeIdException e) {
            System.out.println(e.getMessage());
        }
    }

    void validate() throws InvalidEmailException, InvalidEmployeeIdException {
        super.validate();

        boolean isValid = true;
        int atIndex = -1;
        int splCharIndex = -1;

        for (int i = 0; i < emailId.length(); i++) {
            char ch = emailId.charAt(i);

            if (i == 0 && !Character.isLetterOrDigit(ch)) {
                isValid = false;
                break;
            }

            if (ch == '@') {
                atIndex = i;
            } else if (!Character.isLetterOrDigit(ch) && ch != '.' && ch != '_') {
                splCharIndex = i;
            }
        }

        if (atIndex == -1 || splCharIndex == -1 || splCharIndex > atIndex) {
            isValid = false;
        }

        if (!isValid) {
            throw new InvalidEmailException("Invalid email");
        }

        if (!employeeId.startsWith("emp") || employeeId.length() != 6) {
            throw new InvalidEmployeeIdException("Invalid employee id");
        }

        for (int i = 3; i < employeeId.length(); i++) {
            if (!Character.isDigit(employeeId.charAt(i))) {
                throw new InvalidEmployeeIdException("Invalid employee id");
            }
        }
    }
}

public class q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Test cases

        // ArrayIndexOutOfBoundsException
        int[] arr = new int[3];
        try {
            arr[3] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds!");
        }

        // NullPointerException
        String str = null;
        try {
            int len = str.length();
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception!");
        }

        sc.close();
    }
}