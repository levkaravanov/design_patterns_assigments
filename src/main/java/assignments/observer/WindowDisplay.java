package assignments.observer;

public class WindowDisplay implements WeatherObserver {
    private final String location;

    public WindowDisplay(String location) {
        this.location = location;
    }

    @Override
    public void update(int temperature) {
        System.out.println("[" + location + "] Window display: temperature update -> " + temperature + " C");
    }
}
