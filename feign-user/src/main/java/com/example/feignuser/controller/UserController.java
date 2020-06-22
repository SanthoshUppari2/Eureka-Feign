package com.example.feignuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feignuser.dto.Order;
import com.example.feignuser.feignclient.OrderClient;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	OrderClient orderClient;
	
	@GetMapping("/test")
	public String test() {
		return "Success";
	}
	
	@GetMapping("")
	public List<Order> getAllOrders(){
		return orderClient.getAll();
	}
	
	@GetMapping("/{userId}")
	public List<Order> getAllById(@PathVariable String userId){
		return orderClient.test(userId);
	}
	
	@PostMapping("/byparam")
	public List<Order> getAllByPostReqParam(@RequestParam String userId){
		return orderClient.getAllByPostReqParam(userId);
	}
	
	@PostMapping("/bybody")
	public Order getAllByPostReqBody(@RequestBody Order order){
		return orderClient.getAllByPostReqBody(order);
	}
	
}
