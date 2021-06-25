package Planning;

public class DailyReport {
    private final Sort report;

    public DailyReport(Sort report) {
        this.report = report;
    }

    public void printSchedule() {
        report.printEvents();
    }
}
