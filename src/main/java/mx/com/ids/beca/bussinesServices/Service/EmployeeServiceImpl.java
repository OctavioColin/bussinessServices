package mx.com.ids.beca.bussinesServices.Service;

import mx.com.ids.beca.bussinesServices.Model.Country;
import mx.com.ids.beca.bussinesServices.Model.Employee;
import mx.com.ids.beca.bussinesServices.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> employeeBD = this.employeeRepository.findById(id);
        if(employeeBD.isPresent()){
            return employeeBD.get();
        }else{
            throw new RuntimeException("Record not found with id: " + id);
        }
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) this.employeeRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(id);
        if(employeeDB.isPresent()){
            this.employeeRepository.delete(employeeDB.get());
        }else{
            throw new RuntimeException("Record not found with id: " + id);
        }
    }

    @Override
    public Employee update(Employee employee) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(employee.getId());
        if(employeeDB.isPresent()){
            Employee employeeUpdate = employeeDB.get();
            employeeUpdate.setId(employee.getId());
            employeeUpdate.setFirstname(employee.getFirstname());
            employeeUpdate.setSurname(employee.getSurname());
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        }else{
            throw new RuntimeException("Record not found with id:" + employee.getId());
        }
    }
}
