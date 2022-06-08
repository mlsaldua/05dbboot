package com.capmtraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capmtraining.entities.Address;
import com.capmtraining.service.addressService;

@RestController
public class AddressController {
	
	@Autowired
	addressService addrSrv;
	
	@RequestMapping("/addresses")
	public List<Address> readAllAddress(){
		return addrSrv.getAddress();
	}
	
	@PostMapping("/addresses")
	public Address createAddress(@RequestBody Address payload) {
		return addrSrv.createAddress(payload);
	}
}
