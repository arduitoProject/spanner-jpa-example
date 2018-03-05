package nl.topicus.spanner.jpa.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id", nullable = false, updatable = false)
    private String employeeId;

    @Column(name = "name")
    String name;

    @Column(name = "lastname")
    String lastname;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable
            (
                    name="emp_phone",
                    joinColumns={ @JoinColumn(name="employee_id", referencedColumnName="employee_id") },
                    inverseJoinColumns={ @JoinColumn(name="phone_id", referencedColumnName="phone_id", unique=true) }
            )
    @OrderColumn(name = "phone_order")
    private List<Phone> phones;



    public Employee() {}

    public Employee(String id, String name, String lastname, List<Phone> phones) {
        this.employeeId = id;
        this.name = name;
        this.lastname = lastname;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
