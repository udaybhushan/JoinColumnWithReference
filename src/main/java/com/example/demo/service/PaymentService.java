package com.example.demo.service;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Payment;
import com.example.demo.entities.PaymentStatus;
import com.example.demo.entities.PaymentStatusReason;
import com.example.demo.entities.Sender;
import com.example.demo.entities.SenderContact;
import com.example.demo.model.PaymentModel;
import com.example.demo.repositories.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	EntityManager entityManager;
	@Autowired
	PaymentRepository repo;

	public Payment save(TransactionStatus transactionStatus) {
		Payment payment = new Payment();
		payment.setAgentTxRefNo(model.getAgentTxRefNo());
		payment.setReferenceNo(model.getReferenceNo());
		payment.setMode(model.getMode());

		OffsetDateTime offsetDateTime = OffsetDateTime.parse(model.getTxCreationDate(),
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").withZone(ZoneId.of("+00:00")));
		System.out.println("offset  " + offsetDateTime);
		payment.setTxCreationDate(offsetDateTime);

		List<PaymentStatus> listStatus = new ArrayList<>();
		PaymentStatus paymentStatus = new PaymentStatus();
		paymentStatus.setStatus(model.getPaymentStatues().get(0).getStatus());
		PaymentStatusReason paymentStatusReason = new PaymentStatusReason();
		paymentStatusReason.setReason(model.getPaymentStatues().get(0).getPaymentStatusReason().getReason());
		paymentStatusReason.setPaymentStatus(paymentStatus);
		paymentStatus.setPaymentStatusReason(paymentStatusReason);
		listStatus.add(paymentStatus);
		payment.setPaymentStatues(listStatus);
		paymentStatus.setPayment(payment);

		Sender sender = new Sender();
		sender.setSenderName(model.getSender().getSenderName());
		sender.setSenderMobile(model.getSender().getSenderMobile());

		List<SenderContact> listSenderContact = new ArrayList<>();
		SenderContact senderContact = new SenderContact();
		senderContact.setAddress(model.getSender().getSenderContacts().get(0).getAddress());
		senderContact.setSender(sender);
		listSenderContact.add(senderContact);
		sender.setSenderContacts(listSenderContact);
		sender.setPayment(payment);
		payment.setSender(sender);

		return repo.save(payment);
	}

	@Transactional
	public Payment getTx(String refNo) {
		/*
		 * Session session = entityManager.unwrap(Session.class); Payment b =
		 * session.bySimpleNaturalId(Payment.class).load(refNo);
		 */
		return repo.findById(refNo).get();
	}

}
