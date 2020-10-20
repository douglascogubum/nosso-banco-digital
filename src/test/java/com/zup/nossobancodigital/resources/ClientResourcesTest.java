package com.zup.nossobancodigital.resources;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
class ClientResourcesTest {
	static final int CREATED = 201;
	static final int BAD_REQUEST = 400;

	@Autowired
	private MockMvc mockMvc;	
	
	@Test	
	public void successCase() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"357.672.271-87\"}";
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
		String json = "{\"firstName\":\"\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"357.672.271-87\"}";
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST))
		.andExpect(jsonPath("$[0].field", is("firstName")))
		.andExpect(jsonPath("$[0].error", is("must not be empty")));
		
	}
	
	@Test	
	public void emptyLastName() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"357.672.271-87\"}";
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST))
		.andExpect(jsonPath("$[0].field", is("lastName")))
		.andExpect(jsonPath("$[0].error", is("must not be empty")));
		
	}
	
	@Test	
	public void emptyEmail() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"357.672.271-87\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST))
		.andExpect(jsonPath("$[0].field", is("email")))
		.andExpect(jsonPath("$[0].error", is("Invalid email format.")));
	}
	
	@Test	
	public void emptyDate() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"\","
				+ "\"cpf\":\"357.672.271-87\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST))
		.andExpect(jsonPath("$[0].field", is("birthDate")))
		.andExpect(jsonPath("$[0].error", is("Invalid date.")));
	}
	
	@Test	
	public void wrongFormatDate() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"2020-05-15\","
				+ "\"cpf\":\"357.672.271-87\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST))
		.andExpect(jsonPath("$[0].field", is("birthDate")))
		.andExpect(jsonPath("$[0].error", is("Invalid date.")));
	}
	
	@Test	
	public void futureDate() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"28/12/2020\","
				+ "\"cpf\":\"357.672.271-87\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST))
		.andExpect(jsonPath("$[0].field", is("birthDate")))
		.andExpect(jsonPath("$[0].error", is("Invalid date.")));
	}
	
	@Test	
	public void underEighteenDate() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"28/12/2015\","
				+ "\"cpf\":\"357.672.271-87\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST))
		.andExpect(jsonPath("$[0].field", is("birthDate")))
		.andExpect(jsonPath("$[0].error", is("Invalid date.")));
	}
	
	@Test	
	public void invalidFormatCpf() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"357-672-271-87\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST))
		.andExpect(jsonPath("$[0].field", is("cpf")))
		.andExpect(jsonPath("$[0].error", is("Invalid CPF format.")));
	}
	
	@Test	
	public void invalidCpf() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"358.672.271.87\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
							.status()
							.is(BAD_REQUEST))
		.andExpect(jsonPath("$[0].field", is("cpf")))
		.andExpect(jsonPath("$[0].error", is("Invalid CPF format.")));
	}
	
	@Test	
	public void duplicateEmail() throws Exception {
		URI uri = new URI("/client");
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"357.672.271-87\"}";
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andReturn();
		
		json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"357.672.270-86\"}";
		
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
		String json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum@gmail.com\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"357.672.271-87\"}";
		mockMvc
		.perform(MockMvcRequestBuilders
							.post(uri)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON))
		.andReturn();
		
		json = "{\"firstName\":\"Douglas\","
				+ "\"lastName\":\"Cogubum\","
				+ "\"email\":\"doug.cogubum1@gmail.com\","
				+ "\"birthDate\":\"15/03/1983\","
				+ "\"cpf\":\"357.672.271-87\"}";
		
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