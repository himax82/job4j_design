package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {

    private boolean allroad;
    private String brand;
    private int price;
    private Engine engine;
    private String[] options;

    public Car(boolean allroad, String brand, int price, Engine engine, String... options) {
        this.allroad = allroad;
        this.brand = brand;
        this.price = price;
        this.engine = engine;
        this.options = options;
    }

    @Override
    public String toString() {
        return "Car{" +
                "allroad=" + allroad +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", engine=" + engine +
                ", options=" + Arrays.toString(options) +
                '}';
    }

    public static void main(String[] args) {
        final Car car = new Car(false, "BMW", 50000, new Engine(4.2), "leather", "navigator");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        /* Модифицируем json-строку */
        final String carJson =
                "{"
                        + "\"allroad\":true,"
                        + "\"brand\":Toyota,"
                        + "\"price\":70000,"
                        + "\"engine\":"
                        + "{"
                        + "\"volume\":\"5.7\""
                        + "},"
                        + "\"options\":"
                        + "[\"leather\",\"navigator\"]"
                        + "}";
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
    }
}
