package Planning;

import java.util.ArrayList;

public class TimeTable {
    public static void print() {
        // Monday
        Event event1 = new Event("Playing UNO", 6, "am", 7, "am", false);
        Event event2 = new Event("Running", 6, "pm", 7, "pm", false);
        Event event4 = new Event("Running", 8, "pm", 9, "pm", false);
        Event event5 = new Event("Exam", 12, "am", 3, "pm", true);

        ArrayList<Event> day1 = new ArrayList<>();
        day1.add(event1);
        day1.add(event2);
        day1.add(event4);
        day1.add(event5);

        // Tuesday
        Event event6 = new Event("Running", 7, "pm", 8, "pm", false);
        Event event7 = new Event("Playing chess with Michael", 8, "am", 9, "am", false);
        Event event8 = new Event("Driving", 6, "pm", 7, "pm", true);

        ArrayList<Event> day2 = new ArrayList<>();
        day2.add(event6);
        day2.add(event7);
        day2.add(event8);

        // Choose a report type for each day
        ReportAlpha report1 = new ReportAlpha("Monday", day1);
        ReportAmToPm report2 = new ReportAmToPm("Tuesday", day2);

        MultipleDaysReport report = new MultipleDaysReport(new DailyReport[]{new DailyReport(report1), new DailyReport((report2))});
        report.printReport();
    }
}
