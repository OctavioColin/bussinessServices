package mx.com.ids.beca.bussinesServices.Repository;

import mx.com.ids.beca.bussinesServices.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
}
