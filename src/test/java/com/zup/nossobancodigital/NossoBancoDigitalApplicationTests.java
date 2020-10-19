package com.zup.nossobancodigital;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zup.nossobancodigital.entities.Client;
import com.zup.nossobancodigital.services.ClientService;

@SpringBootTest
class NossoBancoDigitalApplicationTests {

	@Autowired
	private ClientService service;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void passTestPostComplete() {
		service.insert(new Client(null, "Douglas", "Cogubum", "doug.cogubum@gmail.com", "28/05/1986", "35343376894"));
	}
}
