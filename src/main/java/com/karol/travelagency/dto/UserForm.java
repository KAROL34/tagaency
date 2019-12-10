package com.karol.travelagency.dto;

import com.karol.travelagency.security.model.Role;

import java.util.Set;

public class UserForm {
    public UserForm() {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.repPassword = repPassword;
        this.email = email;
    }

    private String firstName;
    private String lastName;
    private String password;
    private String repPassword;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepPassword() {
        return repPassword;
    }

    public void setRepPassword(String repPassword) {
        this.repPassword = repPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
