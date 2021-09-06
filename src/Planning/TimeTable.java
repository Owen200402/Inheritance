package Planning;

import java.util.ArrayList;

public class TimeTable {
    public static void print() {
        // Monday
        Event event1 = new Event("Studying", 6, "am", 7, "am", false);
        Event event2 = new Event("Running", 6, "pm", 7, "pm", false);
        Event event3 = new Event("Playing Card Game", 8, "pm", 9, "pm", false);
        Event event4 = new Event("Exam", 12, "am", 3, "pm", true);

        ArrayList<Event> day1 = new ArrayList<>();
        day1.add(event1);
        day1.add(event2);
        day1.add(event3);
        day1.add(event4);

        // Tuesday
        Event event5 = new Event("Running", 7, "pm", 8, "pm", false);
        Event event6 = new Event("Playing chess with Michael", 8, "am", 9, "am", false);
        Event event7 = new Event("Driving", 6, "pm", 7, "pm", true);

        ArrayList<Event> day2 = new ArrayList<>();
        day2.add(event5);
        day2.add(event6);
        day2.add(event7);

        // Wednesday
        Event event8 = new Event("Tutoring", 3.30, "pm", 5.00, "pm", false);
        Event event9 = new Event("Reading", 8, "am", 9, "am", false);
        Event event10 = new Event("Computer Science Learning", 11, "am", 12, "am", true);

        ArrayList<Event> day3 = new ArrayList<>();
        day3.add(event8);
        day3.add(event9);
        day3.add(event10);

        // Choose a report type for each day
        ReportAlpha report1 = new ReportAlpha("Monday", day1);
        ReportAmToPm report2 = new ReportAmToPm("Tuesday", day2);
        ReportPmToAm report3 = new ReportPmToAm("Wednesday", day3);


        MultipleDaysReport report = new MultipleDaysReport(new DailyReport[]{new DailyReport(report1), new DailyReport((report2)), new DailyReport(report3)});
        report.printReport();
    }
}
