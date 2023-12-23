package com.example.demo.schedular;

import com.example.demo.entity.Flight;
import com.example.demo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class FlightDataScheduler {

    private final FlightService flightService;

    @Autowired
    public FlightDataScheduler(FlightService flightService) {  // Constructor name should match the class name
        this.flightService = flightService;
    }

    @Scheduled(cron = "0 0 1 * * *")
    public void fetchFlightData() {
        // Mock uçuş verileri oluştur
        Flight flight = new Flight();
        flight.setDepartureAirport("Airport A");
        flight.setArrivalAirport("Airport B");
        flight.setDepartureDatetime(LocalDateTime.now());
        flight.setReturnDatetime(LocalDateTime.now().plusDays(2));
        flight.setPrice(new BigDecimal("199.99"));

        flightService.saveFlight(flight);
    }
}
