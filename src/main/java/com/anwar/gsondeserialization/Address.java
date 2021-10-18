package com.anwar.gsondeserialization;

public class Address {
    private String houseNumber;
    private String street;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String houseNumber, String street, String city, String country) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
