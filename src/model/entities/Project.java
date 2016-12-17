package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "Projects")
public class Project {
    @Id
    @Column(name = "projectID")
    private int projectId;
    @Column(name = "developerName")
    private String projectName;
    @Column(name = "projectCompanyID")
    private Company projectCompanyId;
    @Column(name = "projectCustomerID")
    private Customer projectCustomerId;
    @Column(name = "projectTimeStamp")
    private Date projectTimeStamp;

    public Project(String projectName, Company projectCompanyId, Customer projectCustomerId, Date projectTimeStamp) {
        this.projectName = projectName;
        this.projectCompanyId = projectCompanyId;
        this.projectCustomerId = projectCustomerId;
        this.projectTimeStamp = projectTimeStamp;
    }

    public Project(int projectId, String projectName, Company projectCompanyId, Customer projectCustomerId, Date projectTimeStamp) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCompanyId = projectCompanyId;
        this.projectCustomerId = projectCustomerId;
        this.projectTimeStamp = projectTimeStamp;
    }

    public Project() {
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Company getProjectCompanyId() {
        return projectCompanyId;
    }

    public void setProjectCompanyId(Company projectCompanyId) {
        this.projectCompanyId = projectCompanyId;
    }

    public Customer getProjectCustomerId() {
        return projectCustomerId;
    }

    public void setProjectCustomerId(Customer projectCustomerId) {
        this.projectCustomerId = projectCustomerId;
    }

    public Date getProjectTimeStamp() {
        return projectTimeStamp;
    }

    public void setProjectTimeStamp(Date projectTimeStamp) {
        this.projectTimeStamp = projectTimeStamp;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectCompanyId=" + projectCompanyId +
                ", projectCustomerId=" + projectCustomerId +
                ", projectTimeStamp=" + projectTimeStamp +
                '}';
    }
}
