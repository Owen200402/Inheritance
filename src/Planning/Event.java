package Planning;

import java.util.Formatter;

public class Event {
    private final String event;
    private double timeFrom;
    private final String amOrPmFrom;
    private final double timeTo;
    private final String amOrPmTo;
    private final boolean urgentOrNot;

    public Event(String event, double timeFrom, String amOrPmFrom, double timeTo, String amOrPmTo, boolean urgentOrNot) {
        this.event = event;
        this.timeFrom = timeFrom;
        this.amOrPmFrom = amOrPmFrom;
        this.timeTo = timeTo;
        this.amOrPmTo = amOrPmTo;
        this.urgentOrNot = urgentOrNot;
    }

//    Getters
    public String getEvent() {
        return event;
    }

    public double getTimeFrom() {
        return timeFrom;
    }

    public double getTimeTo() {
        return timeTo;
    }

    public String getAmOrPmFrom() {
        return amOrPmFrom;
    }

    public String getAmOrPmTo() {
        return amOrPmTo;
    }

//    Setters
    public void setTimeFrom(double set) {
        this.timeFrom = set;
    }


    @Override
    public String toString() {
        String display;
        display = urgentOrNot ? "URGENT!!!" : "LESS URGENT...";

        Formatter formatter = new Formatter();
        formatter.format("%.2f", getTimeFrom());
        String timeFrom = formatter.toString();

        Formatter formatter2 = new Formatter();
        formatter2.format("%.2f", getTimeTo());
        String timeTo = formatter2.toString();


        return getEvent() + ": " + timeFrom + getAmOrPmFrom() + " to " + timeTo + getAmOrPmTo() + " " + "(" + display + ")";
    }
}
