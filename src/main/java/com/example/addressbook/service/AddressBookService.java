package com.example.addressbook.service;

import com.example.addressbook.configuration.JwtUtil;
import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.reposirory.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AddressBookService implements IAddressBookService{
    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    EMailService eMailService;

    @Override
    public List<AddressBookData> getAddresses(AddressBookDTO addressBookDTO) {
        List<AddressBookData> addressBookData = addressBookRepository.findAll();
        System.out.println(addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData saveAddressData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        String tok = jwtUtil.createToken(addressBookData.getId());
        addressBookRepository.save(addressBookData);
        eMailService.sendEmail("emailVerification ",addressBookData.getEMail(),eMailService.textBody("user created successfull "+tok));
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressData(String id, AddressBookDTO addressBookDTO, String token) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
       int tok = jwtUtil.decodeToken(token);
        addressBookData.setId(tok);
        addressBookRepository.save(addressBookData);
        eMailService.updateEmail("data updated",addressBookData.getEMail(),eMailService.textBody("data updated successfull"+tok));
        return addressBookData;
    }

    @Override
    public void deleteAddressData(int id, String token) {
        int token_id = jwtUtil.decodeToken(token);
        addressBookRepository.deleteById(token_id);
    }

    @Override
    public Optional<AddressBookData> getAddressById(int id, String token) {
        int token_id = jwtUtil.decodeToken(token);
        Optional<AddressBookData> addressBookData = addressBookRepository.findById(token_id);
        return addressBookData;
    }
}
