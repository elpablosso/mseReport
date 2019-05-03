package com.maven.pablo.reportingtool.project.entity;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class Project {

    @Id
    private String number;
    private String title;
    private BigDecimal budget;

    @ManyToOne
    private Employee leader;
    private boolean closed;

    public Project() {
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

       public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}