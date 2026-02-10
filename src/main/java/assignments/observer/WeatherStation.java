package assignments.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private final Random random = new Random();
    private final int minTemperature;
    private final int maxTemperature;
    private volatile boolean running = true;
    private int temperature;

    public WeatherStation(int minTemperature, int maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.temperature = random.nextInt(maxTemperature - minTemperature + 1) + minTemperature;
    }

    public synchronized void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private synchronized void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        int nextTemperature = temperature + change;
        if (nextTemperature < minTemperature) {
            nextTemperature = minTemperature;
        }
        if (nextTemperature > maxTemperature) {
            nextTemperature = maxTemperature;
        }
        temperature = nextTemperature;
    }

    public void stopStation() {
        running = false;
        interrupt();
    }

    @Override
    public void run() {
        while (running) {
            updateTemperature();
            notifyObservers();
            try {
                int sleepMillis = (random.nextInt(5) + 1) * 1000;
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                if (!running) {
                    return;
                }
            }
        }
    }
}
