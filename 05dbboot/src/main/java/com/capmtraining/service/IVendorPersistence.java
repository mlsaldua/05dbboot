package com.capmtraining.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capmtraining.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, Long>{ // will give you automatic crud
	List <Vendor> findByCompanyName(String companyName);
	
	//custom query
	@Query(nativeQuery = true, value="SELECT * FROM public.vendor where lower(GST_NO) like %?1% ")
	List <Vendor> lookupVendorsByGST(String GSTNo);
	
}
