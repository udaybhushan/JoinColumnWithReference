package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Payment;

@Repository
public interface PaymentRepository extends NaturalRepository<Payment, String>{


	Optional<Payment> findByReferenceNo(String refNo);

}
