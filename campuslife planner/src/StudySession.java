public class StudySession {

    private Course course;
    private int minutes;

    public StudySession(Course course, int minutes) {
        this.course = course;
        this.minutes = minutes;
    }

    public Course getCourse() {
        return course;
    }

    public int getMinutes() {
        return minutes;
    }

    public double hours() {
        return minutes / 60.0;
    }

    @Override
    public String toString() {
        return "StudySession{course='" + course.getName() + "', minutes=" + minutes + "}";
    }
}