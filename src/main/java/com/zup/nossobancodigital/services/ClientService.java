package com.zup.nossobancodigital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.zup.nossobancodigital.entities.Client;
import com.zup.nossobancodigital.repositories.ClientRepository;
import com.zup.nossobancodigital.resources.exception.ResourceException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public Client insert(Client client) {
		try {
			return repository.save(client);
		} catch(DataIntegrityViolationException e) {
			throw new ResourceException(e.getMessage());
		}
	}
}
