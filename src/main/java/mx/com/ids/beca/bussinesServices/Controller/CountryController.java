package mx.com.ids.beca.bussinesServices.Controller;

import mx.com.ids.beca.bussinesServices.Model.Country;
import mx.com.ids.beca.bussinesServices.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countryDetails/{id}")
    public ResponseEntity<Country> findProductById(@PathVariable int id){
        return ResponseEntity.ok().body(countryService.findById(id));
    }

    @GetMapping("/countryList")
    public ResponseEntity<?> findAll(){
        List<Country> lista = countryService.findAll();
        if (lista.isEmpty()){
            return new ResponseEntity<>("Sin datos.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(countryService.findAll());
    }

    @DeleteMapping("countryDelete/{id}")
    public HttpStatus deleteCountry(@PathVariable int id){
        this.countryService.delete(id);
        return HttpStatus.OK;
    }

    @PutMapping("/countryUpdate/{id}")
    public ResponseEntity<Country> update(@PathVariable int id, @RequestBody Country country){
        country.setId(id);
        return ResponseEntity.ok().body(this.countryService.update(country));
    }
}
