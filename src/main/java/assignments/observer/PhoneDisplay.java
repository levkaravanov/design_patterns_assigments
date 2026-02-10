package assignments.observer;

public class PhoneDisplay implements WeatherObserver {
    private final String name;

    public PhoneDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println("[" + name + "] Phone display: current temperature is " + temperature + " C");
    }
}
