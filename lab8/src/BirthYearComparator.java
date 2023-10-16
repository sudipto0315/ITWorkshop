import java.util.Comparator;

public class BirthYearComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getBirthyear().compareTo(o2.getBirthyear());
    }
}
