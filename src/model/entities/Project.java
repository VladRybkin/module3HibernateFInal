package model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Projects")
public class Project {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "project_ID")
    private int projectId;

    @Column(name = "developer_Name")
    private String projectName;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "projectCompanyID")
    private Company projectCompanyId;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "project_Customer_ID")
    private Customer projectCustomerId;

    @Column(name = "project_Time_Stamp")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (projectName != null ? !projectName.equals(project.projectName) : project.projectName != null) return false;
        if (projectCompanyId != null ? !projectCompanyId.equals(project.projectCompanyId) : project.projectCompanyId != null)
            return false;
        if (projectCustomerId != null ? !projectCustomerId.equals(project.projectCustomerId) : project.projectCustomerId != null)
            return false;
        return projectTimeStamp != null ? projectTimeStamp.equals(project.projectTimeStamp) : project.projectTimeStamp == null;

    }

    @Override
    public int hashCode() {
        int result = projectName != null ? projectName.hashCode() : 0;
        result = 31 * result + (projectCompanyId != null ? projectCompanyId.hashCode() : 0);
        result = 31 * result + (projectCustomerId != null ? projectCustomerId.hashCode() : 0);
        result = 31 * result + (projectTimeStamp != null ? projectTimeStamp.hashCode() : 0);
        return result;
    }
}
