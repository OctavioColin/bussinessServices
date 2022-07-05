package mx.com.ids.beca.bussinesServices.Service;

import mx.com.ids.beca.bussinesServices.Model.Country;
import mx.com.ids.beca.bussinesServices.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country findById(Integer id) {
        Optional<Country> countryDB = this.countryRepository.findById(id);
        if(countryDB.isPresent()){
            return countryDB.get();
        }else{
            throw new RuntimeException("Record not found with id: " + id);
        }
    }

    @Override
    public List<Country> findAll() {
        return (List<Country>) this.countryRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Optional<Country> countryDB = this.countryRepository.findById(id);
        if(countryDB.isPresent()){
            this.countryRepository.delete(countryDB.get());
        }else{
            throw new RuntimeException("Record not found with id: " + id);
        }
    }

    @Override
    public Country update(Country country) {
        Optional<Country> countryDB = this.countryRepository.findById(country.getId());
        if(countryDB.isPresent()){
            Country countryUpdate = countryDB.get();
            countryUpdate.setId(country.getId());
            countryUpdate.setName(country.getName());
            countryUpdate.setCode(country.getCode());
            countryRepository.save(countryUpdate);
            return countryUpdate;
        }else{
            throw new RuntimeException("Record not found with id:" + country.getId());
        }
    }
}
