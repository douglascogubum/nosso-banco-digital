package com.zup.nossobancodigital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateBirth;
			dateBirth = sdf.parse("28/05/1986");
			service.insert(new Client(null, "Douglas", "Cogubum", "doug.cogubum@gmail.com", dateBirth, "35343376894"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
