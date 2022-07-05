package mx.com.ids.beca.bussinesServices.Service;

import mx.com.ids.beca.bussinesServices.Model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee findById(Integer id);
    public List<Employee> findAll();
    public void delete(Integer id);
    public Employee update(Employee employee);
}
