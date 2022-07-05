package mx.com.ids.beca.bussinesServices.Controller;

import mx.com.ids.beca.bussinesServices.Model.Airport;
import mx.com.ids.beca.bussinesServices.Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airportDetails/{id}")
    public ResponseEntity<Airport> findProductById(@PathVariable int id){
        return ResponseEntity.ok().body(airportService.findById(id));
    }

    @GetMapping("/airportList")
    public ResponseEntity<?> findAll(){
        List<Airport> lista = airportService.findAll();
        if (lista.isEmpty()){
            return new ResponseEntity<>("Sin datos.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(airportService.findAll());
    }

    @DeleteMapping("airportDelete/{id}")
    public HttpStatus deleteAirport(@PathVariable int id){
        this.airportService.delete(id);
        return HttpStatus.OK;
    }

    @PutMapping("/airportUpdate/{id}")
    public ResponseEntity<Airport> update(@PathVariable int id, @RequestBody Airport airport){
        airport.setId(id);
        return ResponseEntity.ok().body(this.airportService.update(airport));
    }

}
