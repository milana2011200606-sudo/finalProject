public class StudySession extends PlanItem {

    private Course course;
    private int minutes;

    public StudySession(Course course, int minutes) {
        super("Study: " + course.getName(), (int)Math.ceil(minutes / 60.0), 0);
        this.course = course;
        this.minutes = minutes;
    }

    public Course getCourse() { return course; }
    public int getMinutes() { return minutes; }

    public double hours() {
        return minutes / 60.0;
    }

    @Override
    public String getCategory() {
        return "STUDY";
    }

    @Override
    public double getUrgencyScore() {
        if (completed) return 0;
        // срочность зависит от длительности
        return minutes / 30.0;
    }

    @Override
    public String display() {
        String status = completed ? "COMPLETED" : "PENDING";
        return String.format("[%s] %s | minutes=%d | urgency=%.2f | %s",
                getCategory(), title, minutes, getUrgencyScore(), status);
    }

    @Override
    public String toString() {
        return display();
    }
}