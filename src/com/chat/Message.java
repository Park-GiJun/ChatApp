package com.chat;

public class Message {
	private String text;
	private String senderName;

	public Message(String text, String senderName) {
		this.text = text;
		this.senderName = senderName;
	}

	public String getText() {
		return text;
	}

	public String getSenderName() {
		return senderName;
	}
}
