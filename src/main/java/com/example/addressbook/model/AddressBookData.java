package com.example.addressbook.model;

import com.example.addressbook.dto.AddressBookDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Addressbook")
public class AddressBookData {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String zip;
    private String city;
    private Boolean verify;

    public AddressBookData() {
    }

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.firstname;
        this.lastName = addressBookDTO.lastName;
        this.eMail = addressBookDTO.eMail;
        this.zip = addressBookDTO.zip;
        this.city = addressBookDTO.city;
        this.verify = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
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
        return "AddressBookData{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
