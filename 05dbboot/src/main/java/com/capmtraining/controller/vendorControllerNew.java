package com.capmtraining.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.capmtraining.entities.Vendor;

//NOTE: This will only work for simple CRUD and not with foreign and primary keys. this is more like calling EntitySet

@RepositoryRestResource(collectionResourceRel = "vendor", path="newVendor")
public interface vendorControllerNew extends JpaRepository<Vendor, Long>{

}
