package com.zup.nossobancodigital.services;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.nossobancodigital.entities.Client;
import com.zup.nossobancodigital.repositories.ClientRepository;
import com.zup.nossobancodigital.services.exceptions.FieldsException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public Client insert(Client client) {
		try {
			return repository.save(client);
		} catch (ConstraintViolationException e) {
			throw new FieldsException(e.getMessage());
		}
	}
}
