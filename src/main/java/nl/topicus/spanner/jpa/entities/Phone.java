package nl.topicus.spanner.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "phone_id", nullable = false, updatable = false)
    private String phoneId;

    @Column(name = "nro_tel")
    private Integer number;

    public Phone(){}

    public Phone(String phoneId, Integer number) {
        this.phoneId = phoneId;
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
