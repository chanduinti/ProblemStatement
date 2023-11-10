
package com.bbtutorials.users.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbtutorials.users.repository.CityRepository;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<City> findShortestPath(List<Long> cityIds) {
        // Implement logic to calculate the shortest path
        // You may use graph algorithms like Dijkstra's algorithm
        // and interact with the CityRepository to fetch city details
        // Return the list of cities in the shortest path order
        // For simplicity, let's return the selected cities in the same order for now
        return cityRepository.findAllById(cityIds);
    }
}