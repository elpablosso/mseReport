package com.maven.pablo.reportingtool.security;

import com.maven.pablo.reportingtool.employee.EmployeeService;
import com.maven.pablo.reportingtool.employee.entity.Employee;
import com.maven.pablo.reportingtool.employee.enums.Role;
import com.maven.pablo.reportingtool.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsMy implements UserDetailsService {

    EmployeeService employeeService;

    @Autowired
    public UserDetailsMy(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private List<GrantedAuthority> getAuthorities(Employee employee) {
        String roleName = employee.getRole().name();
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
        ArrayList<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(grantedAuthority);
        return authorityList;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails
    loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Employee employee = null;
        try {
            employee = employeeService.findById(username);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        CustomUser user = new CustomUser(employee.getId(),
        employee.getUsername(),employee.getPassword(),getAuthorities(employee));
        return user;
    }
}


