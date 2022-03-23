package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    List<AddressBookData> getAddresses(AddressBookDTO addressBookDTO);
    AddressBookData saveAddressData(AddressBookDTO addressBookDTO);
    AddressBookData updateAddressData(String id,AddressBookDTO addressBookDTO, String token);
    void deleteAddressData(int id, String token);
    Optional<AddressBookData> getAddressById(int id, String token);
}
