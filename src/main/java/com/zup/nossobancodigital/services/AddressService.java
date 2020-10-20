package com.zup.nossobancodigital.services;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.zup.nossobancodigital.entities.Address;
import com.zup.nossobancodigital.repositories.AddressRepository;
import com.zup.nossobancodigital.resources.exception.ResourceException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	public Address insert(Address address) {
		try {
			return repository.save(address);
		} catch(DataIntegrityViolationException|ConstraintViolationException e) {
			throw new ResourceException(e.getMessage());
		}		
	}
}
