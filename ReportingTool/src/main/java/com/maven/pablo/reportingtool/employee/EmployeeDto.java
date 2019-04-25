package com.maven.pablo.reportingtool.employee;


public class EmployeeDto {

    private String id;
    private String email;
    private String name;
    private String role;

    public EmployeeDto() {
    }

    public EmployeeDto(String id, String email, String name, String role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.role=role;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
