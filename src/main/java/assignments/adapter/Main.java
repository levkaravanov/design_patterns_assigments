package assignments.adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        dateAdapter.setDay(8);
        dateAdapter.setMonth(4);
        dateAdapter.setYear(2026);

        System.out.println("Initial date: " + formatDate(dateAdapter));

        dateAdapter.advanceDays(30);
        System.out.println("Date after advancing 30 days: " + formatDate(dateAdapter));

        dateAdapter.advanceDays(7);
        System.out.println("Date after advancing 7 more days: " + formatDate(dateAdapter));
    }

    private static String formatDate(NewDateInterface date) {
        return String.format("%02d.%02d.%d", date.getDay(), date.getMonth(), date.getYear());
    }
}
