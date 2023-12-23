package com.example.demo.service;

import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Flight not found"));
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found"));
        flight.setDepartureAirport(flightDetails.getDepartureAirport());
        flight.setArrivalAirport(flightDetails.getArrivalAirport());
        flight.setDepartureDatetime(flightDetails.getDepartureDatetime());
        flight.setReturnDatetime(flightDetails.getReturnDatetime());
        flight.setPrice(flightDetails.getPrice());
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found"));
        flightRepository.delete(flight);
    }


}
