package nl.topicus.spanner.jpa.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "company")
public class Company implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "company_id", nullable = false, updatable = false)
    private String companyId;

    @Column(name = "name")
    String name;

    public Company() {}

    public Company(String id, String name) {
        this.companyId = id;
        this.name = name;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
