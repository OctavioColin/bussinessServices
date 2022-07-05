package mx.com.ids.beca.bussinesServices.Repository;

import mx.com.ids.beca.bussinesServices.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
