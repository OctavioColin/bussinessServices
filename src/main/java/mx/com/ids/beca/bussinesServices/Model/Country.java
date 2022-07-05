package mx.com.ids.beca.bussinesServices.Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer country_id;

    private String code;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "airport_id")
    private List<Airport> airports;

    @OneToOne(mappedBy = "country", cascade = CascadeType.ALL)
    private Employee employee;


    public Integer getId() {
        return country_id;
    }

    public void setId(Integer id) {
        this.country_id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", airports=" + airports +
                ", employee=" + employee +
                '}';
    }
}
