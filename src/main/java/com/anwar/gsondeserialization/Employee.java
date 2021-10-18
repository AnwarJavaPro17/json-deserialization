package com.anwar.gsondeserialization;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
    private List<Address> addresses;
    private Contact contact;

    public Employee(Integer id, String firstName, String lastName, String email, Date dob, List<Address> addresses, Contact contact) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.addresses = addresses;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", addresses=" + addresses +
                ", contact=" + contact +
                '}';
    }
}
