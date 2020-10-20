package com.zup.nossobancodigital.resources;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AddressResourcesTest {

	static final int CREATED = 201;
	static final int BAD_REQUEST = 400;

	@Autowired
	private MockMvc mockMvc;	
	
	@Test	
	public void successCase() throws Exception {
		URI uri = new URI("/address");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/03/1983\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(CREATED));	
	}
	
	@Test	
	public void emptyFirstName() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/03/1983\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));
		
	}
	
	@Test	
	public void emptyLastName() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/03/1983\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));
		
	}
	
	@Test	
	public void emptyEmail() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"\","
				+ "        \"birthDate\": \"15/03/1983\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));
	}
	
	@Test	
	public void emptyDate() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));
	}
	
	@Test	
	public void wrongFormatDate() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15-03-1983\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));
	}
	
	@Test	
	public void futureDate() throws Exception {
		URI uri = new URI("/client");
		String json =  "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/03/1983\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));
	}
	
	@Test	
	public void underEighteenDate() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/03/2015\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));
	}
	
	@Test	
	public void invalidFormatCpf() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/03/1983\","
				+ "        \"cpf\": \"357-672-271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));
	}
	
	@Test	
	public void invalidCpf() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/03/1983\","
				+ "        \"cpf\": \"357.672.275-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));
	}
	
	@Test	
	public void duplicateEmail() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/03/1983\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andReturn();
		
		json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/05/1983\","
				+ "        \"cpf\": \"357.672.272-88\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));	
	}
	
	@Test	
	public void duplicateCpf() throws Exception {
		URI uri = new URI("/client");
		String json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/03/1983\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andReturn();
		
		json = "{"
				+ "    \"cep\": \"04257-010\","
				+ "    \"rua\": \"Avenida São João, 124\","
				+ "    \"bairro\": \"Centro\","
				+ "    \"complemento\": \"Nenhum\","
				+ "    \"cidade\": \"São Paulo\","
				+ "    \"estado\": \"SP\","
				+ "    \"client\": {"
				+ "         \"firstName\": \"Douglas\","
				+ "        \"lastName\": \"Cogubum\","
				+ "        \"email\": \"doug1.cogubum@gmail.com\","
				+ "        \"birthDate\": \"15/02/1983\","
				+ "        \"cpf\": \"357.672.271-87\""
				+ "    }"
				+ "}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST));	
	}

}
