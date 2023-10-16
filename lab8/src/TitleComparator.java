import java.util.Comparator;

class TitleComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // Extract last names (title names) from full names
        String lastName1 = getLastName(o1.getName());
        String lastName2 = getLastName(o2.getName());

        // Compare last names
        return lastName1.compareTo(lastName2);
    }

    private String getLastName(String fullName) {
        // Split the full name into parts using a space character
        String[] parts = fullName.split(" ");

        // The last part should be the last name (title name)
        return parts[parts.length - 1];
    }
}