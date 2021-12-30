package com.landeros.entities;

import java.util.Objects;

public class Shark {
    private int sharkId;
    private String firstName;
    private String lastName;
    private String businessName;
    private String username;
    private String password;

    public Shark() {}

    public Shark(int sharkId, String firstName, String lastName, String businessName, String username, String password) {
        this.sharkId = sharkId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.businessName = businessName;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Shark{" +
                "sharkId=" + sharkId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shark shark = (Shark) o;
        return sharkId == shark.sharkId && Objects.equals(firstName, shark.firstName) && Objects.equals(lastName, shark.lastName) && Objects.equals(businessName, shark.businessName) && Objects.equals(username, shark.username) && Objects.equals(password, shark.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharkId, firstName, lastName, businessName, username, password);
    }

    public int getSharkId() {
        return sharkId;
    }

    public void setSharkId(int sharkId) {
        this.sharkId = sharkId;
    }

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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


