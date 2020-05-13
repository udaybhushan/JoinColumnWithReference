package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Payment;
import com.example.demo.model.PaymentModel;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/v1")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/init")
	public ResponseEntity<Payment> init(@RequestBody PaymentModel payment){
		return ResponseEntity.ok().body(paymentService.save(payment)); 
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<Payment> searchTx(@PathVariable("id") String refNo){
		return ResponseEntity.ok().body(paymentService.getTx(refNo));
	}
}
