public class AssignmentTask extends PlanItem {

    private Course course;

    public AssignmentTask(String title, Course course, int estimatedHours, int daysUntilDue) {
        super(title, estimatedHours, daysUntilDue);
        this.course = course;
    }

    public Course getCourse() { return course; }

    @Override
    public String getCategory() {
        return "ASSIGNMENT";
    }

    @Override
    public double getUrgencyScore() {
        if (completed) return 0;

        // дедлайн важнее всего + часы добавляют срочность
        double deadline = 10.0 / (daysUntil + 1);
        double time = estimatedHours * 0.7;
        return deadline + time;
    }

    @Override
    public String display() {
        return super.display() + " | course=" + course.getName();
    }

    @Override
    public String toString() {
        return display();
    }
}