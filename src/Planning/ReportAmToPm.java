package Planning;

import java.util.ArrayList;

public class ReportAmToPm implements Sort {
    private final String date;
    private final ArrayList<Event> events;
    private final ArrayList<Event> arrayList;

    public ReportAmToPm(String date, ArrayList<Event> events) {
        this.date = date;
        this.events = events;
        arrayList = new ArrayList<>();
    }

    private void getNumForPrioritizing() {
        for (Event event : events) {
            if (event.getAmOrPmFrom().equals("pm")) {
                double originalTime = event.getTimeFrom();
                event.setTimeFrom(originalTime + 12);
            }
        }
    }

    private void cancelNumForPrioritizing() {
        for (Event event : arrayList) {
            if (event.getAmOrPmFrom().equals("pm")) {
                double originalTime = event.getTimeFrom();
                event.setTimeFrom(originalTime - 12);
            }
        }
    }

    public void order() {
        Event min = events.get(0);
        int minIndex = 0;
        for (int i = 1; i < events.size(); i++) {
            Event current = events.get(i);
            if (min.getTimeFrom() >= (current.getTimeFrom())) {
                minIndex = i;
                min = current;
            }
        }
        arrayList.add(min);
        events.remove(minIndex);
    }

    private void sort() {
        while (!events.isEmpty()) {
            order();
        }
    }

    @Override
    public void printEvents() {
        getNumForPrioritizing();
        sort();
        cancelNumForPrioritizing();

        System.out.println(date.toUpperCase());
        for (Event event : arrayList) {
            System.out.println(event);
        }
        System.out.println("----------------------------------------------");
    }
}
