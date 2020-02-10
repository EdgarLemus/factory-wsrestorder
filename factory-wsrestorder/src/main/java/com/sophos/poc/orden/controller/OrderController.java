package com.sophos.poc.orden.controller;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.poc.orden.model.Orders;
import com.sophos.poc.orden.model.OrdersResponse;
import com.sophos.poc.orden.model.Status;
import com.sophos.poc.orden.repository.OrdersRepository;

@RestController
@RequestMapping("/api/orden")
public class OrderController {

	@Autowired
	private OrdersRepository orderRepository;
	
	private static final Logger logger = LogManager.getLogger(OrderController.class);
	
	public OrderController(OrdersRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
		
	@RequestMapping(value = "/add", produces = { "application/json", "application/xml" }, consumes = {"application/json", "application/xml"} , method = RequestMethod.POST)
	public ResponseEntity<Status> addOrder(
			@RequestHeader(value = "X-RqUID", required = true) String xRqUID,
			@RequestHeader(value = "X-Channel", required = true) String xChannel,
			@RequestHeader(value = "X-IPAddr", required = true) String xIPAddr,
			@RequestHeader(value = "X-Sesion", required = true) String xSesion, 
			@RequestBody Orders orders) throws IOException 
	{
		String defaultError ="ERROR Ocurrio una exception inesperada";
		boolean save = false;

		try {
			ObjectMapper mapper = new ObjectMapper();
			logger.info("Headers: xSesion["+ xSesion +"] ");
			
			if(!save && orders == null) {
				Status status = new Status("500", defaultError, "Objecto Orden es <NULL>", null);
				ResponseEntity<Status> res = new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
				logger.info("Response ["+ res.getStatusCode() +"] :"+mapper.writeValueAsString(res));
				return res;
			}
			
			if(xRqUID == null || xChannel == null || xIPAddr == null ||  orders == null) {
				Status status = new Status("500", defaultError, "Valor <NULL> en alguna cabecera obligatorio (X-RqUID X-Channel X-IPAddr X-Sesion)", null);
				ResponseEntity<Status> res = new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
				logger.info("Response ["+ res.getStatusCode() +"] :"+mapper.writeValueAsString(res));
				return res;
			}
			
			
			orders.setId(UUID.randomUUID().toString());
			orders.setApprovalCode(System.currentTimeMillis()+"".lastIndexOf(4)+"");
			orders.setCreateDate(new Date());
			orderRepository.save(orders);
			OrdersResponse response = new OrdersResponse(orders.getApprovalCode());
			Status status = new Status("0", "Operacion Exitosa", "", response);
			
			if(orders.getIdSession() == null || orders.getIdSession().isEmpty())
				orders.setIdSession(UUID.randomUUID().toString());
			orders.setCreateDate(new Date());
		
			ResponseEntity<Status> res = new ResponseEntity<>(status, HttpStatus.OK);
			logger.info("Response ["+ res.getStatusCode() +"] :"+mapper.writeValueAsString(res));
			return res;

		} catch (Exception e) {
			logger.error(defaultError, e);
			Status status = new Status("500", defaultError, e.getMessage(), null);
			ResponseEntity<Status> res = new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
			return res;
		}
	}
}
