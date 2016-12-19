package model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "developer_ID")
    private int developerId;

    @Column(name = "developer_Name")
    private String developerName;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "developerCompanyID")
    private Company developerCompanyId;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @OneToMany()
    @JoinColumn(name = "project_ID")
    @Column(name = "developerProject_ID")
    private Project developerProjectId;

    @Column(name = "developer_Join_Date")
    private Date developerJoinDate;

    public Developer(String developerName, Company developerCompanyId, Project developerProjectId, Date developerJoinDate) {
        this.developerName = developerName;
        this.developerCompanyId = developerCompanyId;
        this.developerProjectId = developerProjectId;
        this.developerJoinDate = developerJoinDate;
    }

    public Developer(int developerId, String developerName, Company developerCompanyId, Project developerProjectId, Date developerJoinDate) {
        this.developerId = developerId;
        this.developerName = developerName;
        this.developerCompanyId = developerCompanyId;
        this.developerProjectId = developerProjectId;
        this.developerJoinDate = developerJoinDate;
    }

    public Developer() {
    }

    public Developer(String developerName) {
        this.developerName = developerName;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "developerId=" + developerId +
                ", developerName='" + developerName + '\'' +
                ", developerCompanyId=" + developerCompanyId +
                ", developerProjectId=" + developerProjectId +
                ", developerJoinDate=" + developerJoinDate +
                '}';
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public Company getDeveloperCompanyId() {
        return developerCompanyId;
    }

    public void setDeveloperCompanyId(Company developerCompanyId) {
        this.developerCompanyId = developerCompanyId;
    }

    public Project getDeveloperProjectId() {
        return developerProjectId;
    }

    public void setDeveloperProjectId(Project developerProjectId) {
        this.developerProjectId = developerProjectId;
    }

    public Date getDeveloperJoinDate() {
        return developerJoinDate;
    }

    public void setDeveloperJoinDate(Date developerJoinDate) {
        this.developerJoinDate = developerJoinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (developerName != null ? !developerName.equals(developer.developerName) : developer.developerName != null)
            return false;
        if (developerCompanyId != null ? !developerCompanyId.equals(developer.developerCompanyId) : developer.developerCompanyId != null)
            return false;
        if (developerProjectId != null ? !developerProjectId.equals(developer.developerProjectId) : developer.developerProjectId != null)
            return false;
        return developerJoinDate != null ? developerJoinDate.equals(developer.developerJoinDate) : developer.developerJoinDate == null;

    }

    @Override
    public int hashCode() {
        int result = developerName != null ? developerName.hashCode() : 0;
        result = 31 * result + (developerCompanyId != null ? developerCompanyId.hashCode() : 0);
        result = 31 * result + (developerProjectId != null ? developerProjectId.hashCode() : 0);
        result = 31 * result + (developerJoinDate != null ? developerJoinDate.hashCode() : 0);
        return result;
    }
}
