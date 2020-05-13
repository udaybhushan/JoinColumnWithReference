package com.example.demo.model;

public class PaymentStatusModel {
	private String status;
	private PaymentStatusReasonModel paymentStatusReason;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PaymentStatusReasonModel getPaymentStatusReason() {
		return paymentStatusReason;
	}
	public void setPaymentStatusReason(PaymentStatusReasonModel paymentStatusReason) {
		this.paymentStatusReason = paymentStatusReason;
	}
	
}
