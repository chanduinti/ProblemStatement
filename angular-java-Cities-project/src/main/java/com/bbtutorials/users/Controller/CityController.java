import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbtutorials.users.Service.City;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RestController
@RequestMapping("/api/cities")
public class CityController {
    @Autowired CityService
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("/shortest-path")
    public ResponseEntity<List<City>> findShortestPath(@RequestBody List<Long> cityIds) {
        if (cityIds == null || cityIds.size() < 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<City> shortestPath = cityService.findShortestPath(cityIds);
        
        if (shortestPath.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(shortestPath, HttpStatus.OK);
    }
}