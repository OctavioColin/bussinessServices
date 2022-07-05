package mx.com.ids.beca.bussinesServices.Service;

import mx.com.ids.beca.bussinesServices.Model.Airport;
import mx.com.ids.beca.bussinesServices.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportServiceImpl implements AirportService{

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport findById(Integer id) {
        Optional<Airport> airportDB = this.airportRepository.findById(id);
        if(airportDB.isPresent()){
            return airportDB.get();
        }else{
            throw new RuntimeException("Record not found with id: " + id);
        }
    }

    @Override
    public List<Airport> findAll() {
        return (List<Airport>) this.airportRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Optional<Airport> airportDB = this.airportRepository.findById(id);
        if(airportDB.isPresent()){
            this.airportRepository.delete(airportDB.get());
        }else{
            throw new RuntimeException("Record not found with id: " + id);
        }
    }

    @Override
    public Airport update(Airport airport) {
        Optional<Airport> airportDB = this.airportRepository.findById(airport.getId());
        if(airportDB.isPresent()){
            Airport airportUpdate = airportDB.get();
            airportUpdate.setId(airport.getId());
            airportUpdate.setName(airport.getName());
            airportRepository.save(airportUpdate);
            return airportUpdate;
        }else{
            throw new RuntimeException("Record not found with id:" + airport.getId());
        }
    }
}
