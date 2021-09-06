package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

    @XmlAttribute
    private boolean allroad;
    private String brand;
    private int price;
    private Engine engine;

    @XmlElementWrapper(name = "options")
    @XmlElement(name = "option")
    private String[] options;

    public Car() {
    }

    public Car(boolean allroad, String brand, int price, Engine engine, String... options) {
        this.allroad = allroad;
        this.brand = brand;
        this.price = price;
        this.engine = engine;
        this.options = options;
    }

    public boolean isAllroad() {
        return allroad;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public Engine getEngine() {
        return engine;
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "Car{" + "allroad=" + allroad
                + ", brand='" + brand + '\''
                + ", price=" + price
                + ", engine=" + engine
                + ", options=" + Arrays.toString(options)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        final Car car = new Car(false, "BMW", 50000, new Engine(4.2), "leather", "navigator");

        JSONObject jsonEngine = new JSONObject("{\"engine\":\"4.2\"}");

        List<String> list = new ArrayList<>();
        list.add("lux");
        list.add("winter");
        JSONArray jsonOptions = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("allroad", car.isAllroad());
        jsonObject.put("brand", car.getBrand());
        jsonObject.put("price", car.getPrice());
        jsonObject.put("engine", jsonEngine);
        jsonObject.put("options", jsonOptions);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(car).toString());
    }
}
