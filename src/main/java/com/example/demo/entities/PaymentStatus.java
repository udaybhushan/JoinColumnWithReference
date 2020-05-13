package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PaymentStatus implements Serializable {

	private static final long serialVersionUID = 8986341545362998783L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PAYMENT_ID")
	@JsonBackReference
	private Payment payment;

	@Column
	private String status;

	@OneToOne(mappedBy = "paymentStatus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private PaymentStatusReason paymentStatusReason;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentStatusReason getPaymentStatusReason() {
		return paymentStatusReason;
	}

	public void setPaymentStatusReason(PaymentStatusReason paymentStatusReason) {
		this.paymentStatusReason = paymentStatusReason;
	}

}
