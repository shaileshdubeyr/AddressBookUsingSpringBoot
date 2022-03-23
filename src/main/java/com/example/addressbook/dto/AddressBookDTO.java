package com.example.addressbook.dto;

public class AddressBookDTO {
    public String firstname;
    public String lastName;
    public String eMail;
    public String zip;
    public String city;

    public AddressBookDTO(String firstname, String lastName, String eMail, String zip, String city) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.eMail = eMail;
        this.zip = zip;
        this.city = city;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}