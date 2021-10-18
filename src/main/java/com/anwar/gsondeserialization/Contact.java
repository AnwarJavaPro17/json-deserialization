package com.anwar.gsondeserialization;

public class Contact {

    private String mobile;
    private String officePhone;
    private String housePhone;

    public Contact() {
    }

    public Contact(String mobile, String officePhone, String housePhone) {
        this.mobile = mobile;
        this.officePhone = officePhone;
        this.housePhone = housePhone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "mobile='" + mobile + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", housePhone='" + housePhone + '\'' +
                '}';
    }
}
