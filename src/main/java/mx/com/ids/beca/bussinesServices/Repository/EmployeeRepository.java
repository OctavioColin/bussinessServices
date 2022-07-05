package mx.com.ids.beca.bussinesServices.Repository;

import mx.com.ids.beca.bussinesServices.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
