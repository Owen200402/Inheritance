package Planning;

import java.util.ArrayList;

public class ReportAlpha implements Sort{
    private final String date;
    private final ArrayList<Event> events;
    private final ArrayList<Event> arrayList;

    public ReportAlpha(String date, ArrayList<Event> events) {
        this.date = date;
        this.events = events;
        arrayList = new ArrayList<>();
    }

    public void order() {
        Event small = events.get(0);
        int minIndex = 0;
        for (int i = 1; i < events.size(); i++) {
            Event current = events.get(i);
            if (small.getEvent().compareTo(current.getEvent()) > 0) {
                minIndex = i;
                small = current;
            }
        }
        arrayList.add(small);
        events.remove(minIndex);
    }

    private void sort() {
        while (!events.isEmpty()) {
            order();
        }
    }

    @Override
    public void printEvents() {
        sort();

        System.out.println(date.toUpperCase());
        for (Event event : arrayList) {
            System.out.println(event);
        }
        System.out.println("----------------------------------------------");
    }
}
