package com.zup.nossobancodigital.resources;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.nossobancodigital.entities.Address;
import com.zup.nossobancodigital.services.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressResources {

	@Autowired
	private AddressService service;
	
	@PostMapping
	public ResponseEntity<Address> insert(@RequestBody @Valid Address Address, HttpServletRequest request) {
		Address = service.insert(Address);
			
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(Address.getId()).toUri();
		URI location = ServletUriComponentsBuilder.fromServletMapping(request).path("/upload/{id}").buildAndExpand(Address.getId()).toUri();
			
		return ResponseEntity.created(uri).location(location).build();
	}
}
