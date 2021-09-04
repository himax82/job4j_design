package ru.job4j.serialization.json;

public class Engine {

    private double volume;

    public Engine(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "volume=" + volume +
                '}';
    }
}
