package mx.com.ids.beca.bussinesServices.Controller;

import mx.com.ids.beca.bussinesServices.Model.Employee;
import mx.com.ids.beca.bussinesServices.Service.EmployeeService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employeeDetails/{id}")
    public ResponseEntity<Employee> findProductById(@PathVariable int id){
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @GetMapping("/employeeList")
    public ResponseEntity<?> findAll(){
        List<Employee> lista = employeeService.findAll();
        if (lista.isEmpty()){
            return new ResponseEntity<>("Sin datos.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(employeeService.findAll());
    }

    @DeleteMapping("employeeDelete/{id}")
    public HttpStatus deleteEmployee(@PathVariable int id){
        this.employeeService.delete(id);
        return HttpStatus.OK;
    }

    @PutMapping("/employeeUpdate/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employee){
        employee.setId(id);
        return ResponseEntity.ok().body(this.employeeService.update(employee));
    }
}
