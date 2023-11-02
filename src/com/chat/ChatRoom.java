package com.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
	private List<String> chatMessages;

	public ChatRoom() {
		chatMessages = new ArrayList<>();
	}

	// 대상자의 채팅방에 메시지 추가
	public void addMessage(String message) {
		chatMessages.add(message);
	}

	// 대상자의 채팅 내용 반환
	public List<String> getChatMessages() {
		return chatMessages;
	}
}
