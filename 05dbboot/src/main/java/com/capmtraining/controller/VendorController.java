package com.capmtraining.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capmtraining.entities.Vendor;
import com.capmtraining.service.vendorService;

@RestController

public class VendorController {
	
	@Autowired
	vendorService vendorService;
	
	// GetEntitySet
	@RequestMapping("/vendor")
	public List<Vendor> getVendors(){
		return vendorService.readAllVendors();
	}
	
	// CREATE_ENTITY
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		return vendorService.createVendor(myPostBody);
	}
	
	// To test: http://localhost:8080/vendor/search?company=SAP
	@RequestMapping("/vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company){
		return vendorService.searchByCompanyName(company);
	}
	
	// To test: http://localhost:8080/vendor/lookup?GSTNo=lai
	/*
	 * @RequestMapping("/vendor/lookup") public List<Vendor>
	 * searchVendorByGST(@RequestParam String GSTNo){ return
	 * vendorService.lookupVendorbyGST(GSTNo); }
	 */
	
	//Request Parameter
	// To test: http://localhost:8080/vendor/lai
	@RequestMapping("/vendor/lookup/{gstNo}")
	public List<Vendor> searchVendorByGST(@PathVariable("gstNo") String GSTNo){
		return vendorService.lookupVendorbyGST(GSTNo);
	}

	//GetEntity
	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") Long code) {
		Optional<Vendor> searchResult = vendorService.getSingleVendor(code);
		if(!searchResult.isPresent()) {
			return new Vendor((long)0, "", "", "", "", "", "", null); // will empty object
		}
		return searchResult.get();
	}
	

	// UPDATE
	@RequestMapping(method=RequestMethod.PUT, value="/vendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorService.changeVendor(vendor);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/vendor/{id}")
	public String removeVendor(@PathVariable("id") Long id) {
		return vendorService.deleteVendor(id);
	}
	

	
}
