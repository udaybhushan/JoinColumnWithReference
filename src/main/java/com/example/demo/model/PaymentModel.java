package com.example.demo.model;

import java.util.List;

public class PaymentModel {

	private String referenceNo;
	private String agentTxRefNo;
	private String mode;
	private String txCreationDate;
	private SenderModel sender;
	private List<PaymentStatusModel> paymentStatues;
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getAgentTxRefNo() {
		return agentTxRefNo;
	}
	public void setAgentTxRefNo(String agentTxRefNo) {
		this.agentTxRefNo = agentTxRefNo;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public SenderModel getSender() {
		return sender;
	}
	public void setSender(SenderModel sender) {
		this.sender = sender;
	}
	public List<PaymentStatusModel> getPaymentStatues() {
		return paymentStatues;
	}
	public void setPaymentStatues(List<PaymentStatusModel> paymentStatues) {
		this.paymentStatues = paymentStatues;
	}
	public String getTxCreationDate() {
		return txCreationDate;
	}
	public void setTxCreationDate(String txCreationDate) {
		this.txCreationDate = txCreationDate;
	}
	
	
}
