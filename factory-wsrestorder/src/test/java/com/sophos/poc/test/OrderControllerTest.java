package com.sophos.poc.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.poc.orden.controller.OrderController;
import com.sophos.poc.orden.model.Orders;
import com.sophos.poc.orden.model.Status;
import com.sophos.poc.orden.repository.OrdersRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderControllerTest {

	@Mock
	private OrdersRepository orderRepository;
	
	@InjectMocks
	private OrderController controller;
	
	private Orders orders = new Orders("1", "null", new Date(), null, null,
			new HashMap<String, String>(), "0", null);
	
	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void orderController_OK() throws Exception {
		
		ResponseEntity<Status> status = controller.addOrder(
				UUID.randomUUID().toString(), 
				"1", 
				"192.168.1.1.",
				"Token",
				orders
			);
		
		assertEquals(status.getBody().getCode(), "0"); 
		//TODO 
		assertEquals(status.getBody().getMessage(), "Operacion Exitosa");
		assertEquals(status.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void orderController_InternalError() throws Exception {
		
		ResponseEntity<Status> status = controller.addOrder(
				UUID.randomUUID().toString(), 
				"1", 
				"192.168.1.1.",
				"Token",
				null
			);
		
		assertEquals(status.getBody().getCode(), "500");
		assertEquals(status.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void orderController_Unauthorized_WithoutToken() throws Exception {
		
		ResponseEntity<Status> status = controller.addOrder(
				UUID.randomUUID().toString(), 
				"1", 
				"192.168.1.1.",
				null,
				orders
			);
		
		assertEquals(status.getBody().getCode(), "500");
		assertEquals(status.getStatusCode(), HttpStatus.UNAUTHORIZED);
	}
	
	@Test
	public void orderController_WithoutSecurity_OK() throws Exception {
		
		ResponseEntity<Status> status = controller.addOrder(
				UUID.randomUUID().toString(), 
				"1", 
				"192.168.1.1.",
				"asdasd",
				orders
			);
		
		assertEquals(status.getBody().getCode(), "0");
		assertEquals(status.getBody().getMessage(), "Operacion Exitosa");
		assertEquals(status.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void orderController_Unauthorized_InvalidToken() throws Exception {
		
		ResponseEntity<Status> status = controller.addOrder(
				UUID.randomUUID().toString(), 
				"1", 
				"192.168.1.1.",
				"Token",
				orders
			);
		
		assertEquals(status.getStatusCode(), HttpStatus.UNAUTHORIZED);
	}
		

}
