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
    @Column(name = "developerID")
    private int developerId;
    @Column(name = "developerName")
    private String developerName;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "developerCompanyID")
    private Company developerCompanyId;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "developerProjectID")
    private Project developerProjectId;
    @Column(name = "developerJoinDate")
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


}
