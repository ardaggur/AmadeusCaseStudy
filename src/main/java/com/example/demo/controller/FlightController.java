package com.example.demo.controller;

import com.example.demo.entity.Flight;
import com.example.demo.service.FlightService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight newFlight = flightService.saveFlight(flight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Flight flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        Flight updatedFlight = flightService.updateFlight(id, flightDetails);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }


}
