package com.zup.nossobancodigital.resources;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.nossobancodigital.entities.Client;
import com.zup.nossobancodigital.services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientResources {

	@Autowired
	private ClientService service;
	
	@PostMapping
	public ResponseEntity<Client> insert( @RequestBody Client client, HttpServletRequest request) {
		client = service.insert(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(client.getId()).toUri();
		URI location = ServletUriComponentsBuilder.fromServletMapping(request).path("/address").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).location(location).build();
	}
}
