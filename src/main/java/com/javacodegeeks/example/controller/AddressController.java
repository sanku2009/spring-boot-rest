package com.javacodegeeks.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javacodegeeks.example.model.Address;
import com.javacodegeeks.example.repository.AddressRepository;

@RestController
public class AddressController {

    private final Logger LOG = LoggerFactory.getLogger(getClass().getName());

    private final AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @PostMapping("/createAdd")
    public @ResponseBody ResponseEntity<Address> createAddress(@RequestBody Address address) {
        LOG.info("Saving Address: {}.", address);
        addressRepository.save(address);
        LOG.info("Address saved: {}.", address);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    @GetMapping("/getAddress/{addressId}")
    public @ResponseBody ResponseEntity<Address> getAddress(@PathVariable Long addressId) {
    	Address address = addressRepository.findOne(addressId);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    @GetMapping("/getAllAddress/all")
    public @ResponseBody ResponseEntity<List<Address>> getAllAddress() {
        List<Address> address = addressRepository.findAll();
        LOG.info("Getting all Data: {}.", address);
        return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
    }

    @PutMapping("/editAddress")
    public @ResponseBody ResponseEntity<Address> editAddress(@RequestBody Address address) {
        LOG.info("Updating Address: {}.", address);
        addressRepository.save(address);
        LOG.info("Address updated: {}.", address);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteAddress/{addressId}")
    public void deleteAddress(@PathVariable Long addressId) {
        LOG.info("Deleting Address with ID {}.", addressId);
        addressRepository.delete(addressId);
        LOG.info("Address deleted.");
    }
}
