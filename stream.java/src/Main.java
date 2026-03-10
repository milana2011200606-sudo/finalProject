import java.util.*;
import java.util.stream.Collectors;

public class Main {

  static class Student {
    String name;
    String group;
    double gpa;

    Student(String name, String group, double gpa) {
      this.name = name;
      this.group = group;
      this.gpa = gpa;
    }

    public String getGroup() {
      return group;
    }

    public double getGpa() {
      return gpa;
    }

    public String toString() {
      return name + " (" + group + ", GPA=" + gpa + ")";
    }
  }

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 4, 8, 9, 10);

    List<String> words = Arrays.asList(
            "apple", "banana", "avocado", "grape", "apricot", "melon", "banana"
    );

    List<Student> students = Arrays.asList(
            new Student("Ali", "SE-1", 3.8),
            new Student("Amina", "SE-1", 3.4),
            new Student("Bek", "SE-2", 3.9),
            new Student("Dana", "SE-2", 3.2),
            new Student("Elina", "SE-1", 3.7),
            new Student("Farid", "SE-3", 3.6)
    );

    List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
    System.out.println("1. Even numbers: " + evenNumbers);

    List<String> upper = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    System.out.println("2. Uppercase: " + upper);

    long countA = words.stream()
            .filter(w -> w.startsWith("a"))
            .count();
    System.out.println("3. Words starting with a: " + countA);

    List<Integer> sorted = numbers.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    System.out.println("4. Sorted desc: " + sorted);

    int max = numbers.stream().max(Integer::compareTo).get();
    int min = numbers.stream().min(Integer::compareTo).get();
    System.out.println("5. Max: " + max);
    System.out.println("   Min: " + min);

    List<Integer> unique = numbers.stream()
            .distinct()
            .collect(Collectors.toList());
    System.out.println("6. Unique numbers: " + unique);

    String joined = words.stream()
            .collect(Collectors.joining(", "));
    System.out.println("7. Joined words: " + joined);

    Map<String, List<Student>> grouped = students.stream()
            .collect(Collectors.groupingBy(Student::getGroup));
    System.out.println("8. Grouped students: " + grouped);

    double avg = students.stream()
            .collect(Collectors.averagingDouble(Student::getGpa));
    System.out.println("9. Average GPA: " + avg);

    List<Student> top = students.stream()
            .filter(s -> s.getGpa() > 3.5)
            .limit(3)
            .collect(Collectors.toList());
    System.out.println("10. Top students: " + top);

    long high = students.stream()
            .filter(s -> s.getGpa() > 3.5)
            .count();
    System.out.println("11. Students with GPA > 3.5: " + high);
  }
}