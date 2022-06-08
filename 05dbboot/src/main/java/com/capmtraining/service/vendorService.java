package com.capmtraining.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.capmtraining.entities.Vendor;

@Component
public class vendorService {
	
	@Autowired
	IVendorPersistence vendor;
	
	public List<Vendor> readAllVendors(){
		return vendor.findAll();
	}
	
//	public Vendor getSingleVendorById(String vendorCode){
//		return (Vendor)vendors.get(vendorCode);
//	}
//	

//	
//	public Vendor changeVendor(Vendor vendorCode){
//		return vendorCode;
//	}
	
	
	/*
	 * private void fillVendor() { // TODO Auto-generated method stub
	 * vendors.put("1", x); vendors.put("2", y); vendors.put("3", z);
	 * 
	 * }
	 */
	
	public Vendor createVendor(Vendor vendorObj) {
		return vendor.save(vendorObj);
	}
	
	public List<Vendor> searchByCompanyName(String companyName){
		return vendor.findByCompanyName(companyName);
	}
	
	public List<Vendor> lookupVendorbyGST(String GSTNo){
		return vendor.lookupVendorsByGST(GSTNo);
	}
	
	public Optional<Vendor> getSingleVendor(Long id) {
		return vendor.findById(id);
	}
	
	public Vendor changeVendor(Vendor payload) {
		//Find
		//Optional<Vendor> myVendor = vendor.findById(vendorId); //Need to declare Long vendorId in method
		Optional<Vendor> myVendor = vendor.findById(payload.getId());
		if (!myVendor.isPresent()) {
			return new Vendor((long)0, "", "", "", "", "", "", null); // will empty object
		}
		return vendor.save(payload);
	}
	
	public String deleteVendor(Long id) {
		vendor.deleteById(id);
		return "Deleted Successfully";
	}
	
}
