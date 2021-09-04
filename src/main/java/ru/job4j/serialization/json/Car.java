package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

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

    public static void main(String[] args) throws Exception {
        final Car car = new Car(false, "BMW", 50000, new Engine(4.2), "leather", "navigator");

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Car result = (Car) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
