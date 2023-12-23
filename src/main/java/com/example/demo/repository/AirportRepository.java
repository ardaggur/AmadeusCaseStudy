package com.example.demo.repository;

import com.example.demo.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {


}
