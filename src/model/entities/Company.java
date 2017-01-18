package model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Vlad on 04.12.2016.
 */
@Entity
@Table (name = "Companies")
public class Company {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "company_id")
    private int companyID;

    @Column(name = "company_name")
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Company(int companyID, String companyName) {
        this.companyID = companyID;
        this.companyName = companyName;
    }

    public Company() {
    }


    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID=" + companyID +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        return companyName != null ? companyName.equals(company.companyName) : company.companyName == null;

    }

    @Override
    public int hashCode() {
        return companyName != null ? companyName.hashCode() : 0;
    }
}
