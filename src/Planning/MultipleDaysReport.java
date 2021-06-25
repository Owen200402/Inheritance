package Planning;

public class MultipleDaysReport {
    private DailyReport[] dailyReport;

    public MultipleDaysReport(DailyReport[] dailyReport) {
        this.dailyReport = dailyReport;
    }

    public void printReport() {
        for (DailyReport report: dailyReport) {
            report.printSchedule();
        }
    }
}
