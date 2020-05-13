package com.example.demo.model;

import java.util.List;

public class SenderModel {
	private String senderName;
	private String senderMobile;
	private List<SenderContactModel> senderContacts;
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderMobile() {
		return senderMobile;
	}
	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}
	public List<SenderContactModel> getSenderContacts() {
		return senderContacts;
	}
	public void setSenderContacts(List<SenderContactModel> senderContacts) {
		this.senderContacts = senderContacts;
	}
	
}
