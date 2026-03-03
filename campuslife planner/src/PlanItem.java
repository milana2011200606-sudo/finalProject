public abstract class PlanItem {

    protected String title;
    protected int daysUntil;
    protected int estimatedHours;
    protected boolean completed;

    public PlanItem(String title, int estimatedHours, int daysUntil) {
        this.title = title;
        this.estimatedHours = Math.max(0, estimatedHours);
        this.daysUntil = Math.max(0, daysUntil);
        this.completed = false;
    }

    public String getTitle() { return title; }
    public int getEstimatedHours() { return estimatedHours; }
    public int getDaysUntil() { return daysUntil; }
    public boolean isCompleted() { return completed; }

    public void markCompleted() {
        this.completed = true;
    }

    public int remainingHours() {
        return completed ? 0 : estimatedHours;
    }

    public abstract String getCategory();
    public abstract double getUrgencyScore();

    public String display() {
        String status = completed ? "COMPLETED" : "PENDING";
        return String.format("[%s] %s | hours=%d | daysLeft=%d | urgency=%.2f | %s",
                getCategory(), title, estimatedHours, daysUntil, getUrgencyScore(), status);
    }
}