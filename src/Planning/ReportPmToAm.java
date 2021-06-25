package Planning;

import java.util.ArrayList;

public class ReportPmToAm implements Sort {
    private final String date;
    private final ArrayList<Event> events;
    private final ArrayList<Event> arrayList;

    public ReportPmToAm(String date, ArrayList<Event> events) {
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
        Event max = events.get(0);
        int maxIndex = 0;
        for (int i = 1; i < events.size(); i++) {
            Event current = events.get(i);
            if (max.getTimeFrom() < (current.getTimeFrom())) {
                maxIndex = i;
                max = current;
            }
        }
        arrayList.add(max);
        events.remove(maxIndex);
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

        System.out.println(date.toLowerCase());
        for (Event event : arrayList) {
            System.out.println(event);
        }
        System.out.println("----------------------------------------------");
    }
}
