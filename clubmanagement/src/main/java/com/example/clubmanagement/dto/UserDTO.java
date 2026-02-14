package com.example.clubmanagement.dto;

public class UserDTO {

    private String username;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private Integer age;
    private String faculty;
    private String batch;
    private String degree;
    private String roleGlobal;

    // Getters & Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getFaculty() { return faculty; }
    public void setFaculty(String faculty) { this.faculty = faculty; }

    public String getBatch() { return batch; }
    public void setBatch(String batch) { this.batch = batch; }

    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }

    public String getRoleGlobal() { return roleGlobal; }
    public void setRoleGlobal(String roleGlobal) { this.roleGlobal = roleGlobal; }
}
