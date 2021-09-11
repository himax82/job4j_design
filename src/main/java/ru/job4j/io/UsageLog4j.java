package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int age = 39;
        double weight = 100.2;
        float height = 1.95f;
        byte children = 3;
        char gender = 'M';
        short iq = 110;
        boolean drivingCar = true;
        long zipCode = 670024;
        LOG.debug("User info age : {}, weight : {}, height : {}, children : {}, gender : {} , iq : {}iq, drivingCar : {}, zipCode : {}",
                age, weight, height, children, gender, iq, drivingCar, zipCode);
    }
}
