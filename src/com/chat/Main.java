package com.chat;

public class Main {
    public static void main(String[] args) {
    	
        // 클라이언트 연결 관리 클래스 생성
        ClientConnection clientConnection = new ClientConnection("14.42.124.35", 12345);

        // 메인 프레임 생성 및 연결 관리 객체 전달
        MainFrame mainFrame = new MainFrame(clientConnection);

        // 메인 프레임 표시
        mainFrame.setVisible(true);
    }
}
