package com.example.carstore.schedule;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CarsSchedule {

    private static final Logger LOGGER = Logger.getLogger("CarsSchedule");


    public void getMostPopularCars() {
        LOGGER.info("Getting most popular cars NOT IMPLEMENTED");
    }
}
