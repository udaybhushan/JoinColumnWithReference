package com.example.demo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1610042163537875577L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	public String id;

	@Column
	public String referenceNo;
	
	@Column
	private String agentTxRefNo;
	
	@Column
	private String mode;
	
	@Column(columnDefinition = "TIMESTAMP")
	private OffsetDateTime txCreationDate;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "payment")
	@JsonManagedReference
	private Sender sender;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "payment")
	@JsonManagedReference
	private List<PaymentStatus> paymentStatues;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public List<PaymentStatus> getPaymentStatues() {
		return paymentStatues;
	}

	public void setPaymentStatues(List<PaymentStatus> paymentStatues) {
		this.paymentStatues = paymentStatues;
	}

	public OffsetDateTime getTxCreationDate() {
		return txCreationDate;
	}

	public void setTxCreationDate(OffsetDateTime txCreationDate) {
		this.txCreationDate = txCreationDate;
	}

}
