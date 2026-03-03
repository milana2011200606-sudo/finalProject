public class ClubEvent extends PlanItem {

    private String location;
    private boolean mandatory;

    public ClubEvent(String title, int daysUntil, int estimatedHours, String location, boolean mandatory) {
        super(title, estimatedHours, daysUntil);
        this.location = location;
        this.mandatory = mandatory;
    }

    @Override
    public String getCategory() {
        return "CLUB_EVENT";
    }

    @Override
    public double getUrgencyScore() {
        if (completed) return 0;

        double deadline = 6.0 / (daysUntil + 1);
        double must = mandatory ? 4.0 : 0.0;
        return deadline + must;
    }

    @Override
    public String display() {
        return super.display() + " | location=" + location + " | " + (mandatory ? "MANDATORY" : "OPTIONAL");
    }

    @Override
    public String toString() {
        return display();
    }
}
