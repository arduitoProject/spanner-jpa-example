package nl.topicus.spanner.jpa.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private Employee.Pk pk;

    @Column(name = "name")
    String name;

    @Column(name = "lastname")
    String lastname;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable
            (
                    name="emp_phone",
                    joinColumns={ @JoinColumn(name="employee_id", referencedColumnName="employee_id"),
                            @JoinColumn(name = "company_id", referencedColumnName = "company_id")},
                    inverseJoinColumns={ @JoinColumn(name="phone_id", referencedColumnName="phone_id", unique=true) }
            )
    @OrderColumn(name = "phone_order")
    private List<Phone> phones;

    public Employee() {}

    public Employee(Pk pk, String name, String lastname, List<Phone> phones) {
        this.pk = pk;
        this.name = name;
        this.lastname = lastname;
        this.phones = phones;
    }

    public Employee.Pk getPk() {
        return pk;
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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }


    @Embeddable
    public static class Pk implements Serializable {

        private static final long serialVersionUID = -1060947912266100708L;

        public Pk() {
        }

        public Pk(String accountId) {
            this(accountId, getUuid());
        }

        public Pk(String accountId, String employeeId) {
            this.companyId = accountId;
            this.employeeId = employeeId;
        }

        @Column(name = "company_id", nullable = false, updatable = false)
        private String companyId;

        @Column(name = "employee_id", nullable = false, updatable = false)
        private String employeeId;

        public String getCompanyId() {
            return companyId;
        }

        public String getEmployeeId() {
            return employeeId;
        }
    }


    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
