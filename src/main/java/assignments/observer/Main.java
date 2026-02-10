package assignments.observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation(-10, 35);

        WeatherObserver phone = new PhoneDisplay("Alice");
        WeatherObserver kitchenWindow = new WindowDisplay("Kitchen");
        WeatherObserver officeWindow = new WindowDisplay("Office");

        station.registerObserver(phone);
        station.registerObserver(kitchenWindow);
        station.registerObserver(officeWindow);

        station.start();

        try {
            Thread.sleep(12000);
            System.out.println("Removing observer: Office");
            station.removeObserver(officeWindow);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            station.stopStation();
        }
    }
}
