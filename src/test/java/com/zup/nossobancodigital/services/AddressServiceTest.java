package com.zup.nossobancodigital.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zup.nossobancodigital.entities.Address;
import com.zup.nossobancodigital.entities.Client;

@SpringBootTest
class AddressServiceTest {

	@Autowired
	private AddressService service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void passTestPostComplete() {
		Client client = new Client(null, "Douglas", "Cogubum", "doug.cogubum@gmail.com", "28/05/1986", "353.433.768-94");
		Address addr = new Address(null, "04257-010", "Avenida São João, 124", "Centro", "Nenhum", "São Paulo", "SP", client);
		service.insert(addr);
	}

}
