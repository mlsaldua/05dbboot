package com.capmtraining.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capmtraining.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, Long>{

}
