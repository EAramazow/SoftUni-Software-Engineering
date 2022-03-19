package com.automappingobjects.entities.dto;

public class CustomDto {
    private String firstName;
    private String lastName;
    private int managerLastNameLength;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setManagerLastNameLength(int managerLastNameLength) {
        this.managerLastNameLength = managerLastNameLength;
    }

    @Override
    public String toString() {
        return "CustomDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", managerLastNameLength=" + managerLastNameLength +
                '}';
    }
}
