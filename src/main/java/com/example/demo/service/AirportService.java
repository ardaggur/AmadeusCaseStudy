package com.example.demo.service;

import com.example.demo.entity.Airport;
import com.example.demo.repository.AirportRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found"));
    }

    public Airport updateAirport(Long id, Airport airportDetails) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found"));
        airport.setCity(airportDetails.getCity());
        return airportRepository.save(airport);
    }

    public void deleteAirport(Long id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found"));
        airportRepository.delete(airport);
    }


}
