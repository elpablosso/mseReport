package com.pablo.application.entity.project;
import com.pablo.application.entity.converter.LocalDateConverter;
import com.pablo.application.entity.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="project")
public class Project {

    @Id
    @Size(min=1, max=32)
    private String number;

    @Convert(converter = LocalDateConverter.class)
    private LocalDate date;

    @Size(min=1, max=32)
    private String name;

    @ManyToMany(mappedBy = "projects")
    private Set<User> users;

    private int budget;

    private boolean closed;

    public Project() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}