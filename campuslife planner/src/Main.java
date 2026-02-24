import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {

    // 1) Courses (2–3)
    Course oop = new Course("OOP", "Dr. Lee", 6);
    Course discrete = new Course("Discrete Math", "Mr. Watson", 5);
    Course english = new Course("English", "Ms. Kim", 3);

    ArrayList<Course> courses = new ArrayList<>();
    courses.add(oop);
    courses.add(discrete);
    courses.add(english);

    // 2) Assignment tasks (4–6)
    AssignmentTask t1 = new AssignmentTask("Lab 1", oop, 2, 5);
    AssignmentTask t2 = new AssignmentTask("Lab 2", oop, 3, 1);     // urgent (<=2)
    AssignmentTask t3 = new AssignmentTask("Homework 1", discrete, 4, 2); // urgent (<=2)
    AssignmentTask t4 = new AssignmentTask("Quiz", discrete, 1, 0); // urgent (<=2)
    AssignmentTask t5 = new AssignmentTask("Essay Draft", english, 5, 6);

    ArrayList<AssignmentTask> tasks = new ArrayList<>();
    tasks.add(t1);
    tasks.add(t2);
    tasks.add(t3);
    tasks.add(t4);
    tasks.add(t5);

    // 3) Study sessions (3–5)
    StudySession s1 = new StudySession(oop, 90);
    StudySession s2 = new StudySession(oop, 60);
    StudySession s3 = new StudySession(discrete, 120);
    StudySession s4 = new StudySession(english, 45);

    ArrayList<StudySession> sessions = new ArrayList<>();
    sessions.add(s1);
    sessions.add(s2);
    sessions.add(s3);
    sessions.add(s4);

    System.out.println("=== Courses ===");
    for (Course c : courses) {
      System.out.println(c);
    }

    System.out.println("\n=== Assignments (urgent highlighted) ===");
    for (AssignmentTask t : tasks) {
      if (t.isUrgent()) {
        System.out.println("[URGENT] " + t);
      } else {
        System.out.println(t);
      }
    }

    int totalRemaining = 0;
    for (AssignmentTask t : tasks) {
      if (!t.isCompleted()) {
        totalRemaining += t.getEstimatedHours();
      }
    }
    System.out.println("\nTotal remaining estimated hours (incomplete): " + totalRemaining);

    System.out.println("\n=== Study time per course (hours) ===");
    Map<Course, Double> studyHoursPerCourse = new HashMap<>();

    for (StudySession s : sessions) {
      Course course = s.getCourse();
      double hours = s.hours();

      double old = studyHoursPerCourse.getOrDefault(course, 0.0);
      studyHoursPerCourse.put(course, old + hours);
    }

    for (Course c : courses) {
      double hrs = studyHoursPerCourse.getOrDefault(c, 0.0);
      System.out.println(c.getName() + ": " + hrs);
    }

    System.out.println("\n=== Mark one assignment completed and reprint ===");

    t2.markCompleted();

    System.out.println("Updated assignment: " + t2);

    int newRemaining = 0;
    for (AssignmentTask t : tasks) {
      if (!t.isCompleted()) {
        newRemaining += t.getEstimatedHours();
      }
    }
    System.out.println("New remaining estimated hours: " + newRemaining);
  }
}