package com.example.addressbook.controller;

import com.example.addressbook.configuration.JwtUtil;
import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    AddressBookService addressBookService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping(value = {"","/","/getaddresses"})
    public ResponseEntity<String> getAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
        List<AddressBookData> addressBookData = addressBookService.getAddresses(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("get call success", addressBookData, null);
        return new ResponseEntity<String>(" "+responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable int id, @RequestParam(name = "token") String token ){
        Optional<AddressBookData> addressBookData = addressBookService.getAddressById(id, token);
        ResponseDTO responseDTO = new ResponseDTO("get by id success", addressBookData,token);
        return new ResponseEntity<String>(" "+responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> saveAddress(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.saveAddressData(addressBookDTO);
        String token = jwtUtil.createToken(addressBookData.getId());
        ResponseDTO responseDTO = new ResponseDTO("create success", addressBookData, token);
        return new ResponseEntity<String>(" "+responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable String id, @RequestBody AddressBookDTO addressBookDTO, @RequestParam(name = "token") String token){
        AddressBookData addressBookData = addressBookService.updateAddressData(id, addressBookDTO, "token verified");
        ResponseDTO responseDTO = new ResponseDTO("update call success", addressBookDTO, id);
        return new ResponseEntity<String>(""+responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id, @RequestParam(name = "token") String token){
        addressBookService.deleteAddressData(id, token);
        ResponseDTO responseDTO = new ResponseDTO("Delete call get success with this ", id,"token verified");
        return new ResponseEntity<String>(""+responseDTO, HttpStatus.OK);
    }

}
