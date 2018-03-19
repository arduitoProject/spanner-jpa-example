package nl.topicus.spanner.jpa.entities;

import java.io.Serializable;

public class EmployeeId implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String companyId;
    private String employeeId;

    public EmployeeId()
    {
    }

    public EmployeeId(String id1, String id2)
    {
        this.companyId = id1;
        this.employeeId = id2;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(String companyId)
    {
        this.companyId = companyId;
    }

}