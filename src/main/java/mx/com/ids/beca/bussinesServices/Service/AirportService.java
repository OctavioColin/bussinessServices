package mx.com.ids.beca.bussinesServices.Service;

import mx.com.ids.beca.bussinesServices.Model.Airport;

import java.util.List;


public interface AirportService {

    public Airport findById(Integer id);
    public List<Airport> findAll();
    public void delete(Integer id);
    public Airport update(Airport language);
}
