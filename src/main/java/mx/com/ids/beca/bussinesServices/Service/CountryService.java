package mx.com.ids.beca.bussinesServices.Service;

import mx.com.ids.beca.bussinesServices.Model.Country;

import java.util.List;

public interface CountryService {
    public Country findById(Integer id);
    public List<Country> findAll();
    public void delete(Integer id);
    public Country update(Country country);
}
