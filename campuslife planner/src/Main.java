import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    // Courses
    Course oop = new Course("OOP", "Dr. Lee", 6);
    Course discrete = new Course("Discrete Math", "Mr. Watson", 5);
    Course english = new Course("English", "Ms. Kim", 3);

    AssignmentTask t1 = new AssignmentTask("Lab 1", oop, 2, 5);
    AssignmentTask t2 = new AssignmentTask("Lab 2", oop, 3, 1);
    AssignmentTask t3 = new AssignmentTask("Homework 1", discrete, 4, 2);

    StudySession s1 = new StudySession(oop, 90);
    StudySession s2 = new StudySession(discrete, 120);

    ClubEvent e1 = new ClubEvent("Tech Club Meetup", 4, 2, "Room B-201", false);
    ClubEvent e2 = new ClubEvent("Volunteer Event", 2, 3, "Main Hall", true);

    ArrayList<PlanItem> items = new ArrayList<>();
    items.add(t1);
    items.add(t2);
    items.add(t3);
    items.add(s1);
    items.add(s2);
    items.add(e1);
    items.add(e2);

    System.out.println("=== ALL PLAN ITEMS ===");
    for (PlanItem item : items) {
      System.out.println(item.display());
    }

    System.out.println("\n=== MARK ONE ITEM COMPLETED ===");
    t2.markCompleted(); // example
    System.out.println("Completed: " + t2.getTitle());

    System.out.println("\n=== ITEMS AFTER COMPLETION ===");
    for (PlanItem item : items) {
      System.out.println(item.display());
    }

    int totalRemaining = 0;
    for (PlanItem item : items) {
      totalRemaining += item.remainingHours();
    }
    System.out.println("\nTotal remaining estimated hours: " + totalRemaining);

    PlanItem mostUrgent = null;
    double best = -1;

    for (PlanItem item : items) {
      double score = item.getUrgencyScore();
      if (score > best) {
        best = score;
        mostUrgent = item;
      }
    }

    if (mostUrgent != null) {
      System.out.println("Most urgent activity: " + mostUrgent.getTitle()
              + " (urgency=" + String.format("%.2f", best) + ")");
    } else {
      System.out.println("Most urgent activity: none");
    }
  }
}