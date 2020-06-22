package com.example.feignuser.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feignuser.dto.Order;

//@FeignClient(value="order-service", url="http://localhost:8081/demo/orders")
@FeignClient(name="http://ORDER-SERVICE/demo/orders")
public interface OrderClient {
	
	@GetMapping("")
	public List<Order> getAll();
	
	@GetMapping("/{userId}")
	public List<Order> test(@PathVariable("userId") String userId);
	
	@PostMapping("/byparam")
	public List<Order> getAllByPostReqParam(@RequestParam("userId") String userId);
	
	@PostMapping("/bybody")
	public Order getAllByPostReqBody(@RequestBody Order order);
	
}
