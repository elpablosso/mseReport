package com.maven.pablo.reportingtool.exceptions;

public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
