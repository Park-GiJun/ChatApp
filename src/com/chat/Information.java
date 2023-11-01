package com.chat;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Information {
    JFrame profile_Frame = new JFrame("정보 수정");
    JPanel profile_Panel = new JPanel();
    JLabel profile_MainText = new JLabel("사원 정보 수정");
    JLabel profile_NumberLabel = new JLabel("사번"); // 사번 라벨
    JLabel profile_Number = new JLabel("ABC10101010"); // 사번 필드
    JLabel profile_NameLabel = new JLabel("이름");
    JLabel profile_Name = new JLabel("홍길동");
    JLabel profile_PwdLabel = new JLabel("비밀번호"); // 비밀번호 라벨
    JPasswordField profile_Pwd = new JPasswordField("", 20); // 비밀번호 수정 필드
    JLabel profile_PwdCheckLabel = new JLabel("비밀번호 확인"); // 비밀번호 확인 라벨
    JPasswordField profile_PwdCheck = new JPasswordField("", 20); // 비밀번호 확인 필드
    JLabel profile_PhoneLabel = new JLabel("휴대폰 번호"); // 핸드폰 번호 라벨
    JTextField profile_Phone = new JTextField(13); // 핸드폰 번호 수정 필드
    JLabel profile_EmailLabel = new JLabel("이메일 주소"); // 메일 주소 라벨
    JTextField profile_Email = new JTextField(50); // 이메일 주소 수정 필드
    JButton profile_ModifyButton = new JButton("저장");
    public Information() {
        profile_Frame.setSize(450, 480);
        profile_Frame.setVisible(true);
        profile_Frame.setResizable(false);
        profile_Frame.setLocationRelativeTo(null);
        profile_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 클릭 시 창닫기

        profile_Frame.add(profile_Panel);
        profile_Panel.setLayout(null);
        profile_Panel.setBackground(Color.white);

        profile_MainText.setFont(new Font("Gothic", Font.BOLD, 16));
        profile_MainText.setBounds(146, 33, 250, 40);

        profile_NumberLabel.setBounds(66, 98, 250, 25);
        profile_Number.setBounds(171, 98, 180, 25);

        profile_NameLabel.setBounds(66, 133, 250, 25);
        profile_Name.setBounds(171, 133, 180, 25);

        profile_PwdLabel.setBounds(66, 173, 250, 25);
        profile_Pwd.setEchoChar('*');
        profile_Pwd.setBounds(171, 171, 150, 25);

        profile_PwdCheckLabel.setBounds(66, 213, 250, 25);
        profile_PwdCheck.setEchoChar('*');
        profile_PwdCheck.setBounds(171, 211, 150, 25);
        JLabel profile_PwdMessage = new JLabel("특수문자를 포함해야 안전합니다.");
        profile_PwdMessage.setBounds(171, 239, 200, 15);

        profile_PwdCheck.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                pwdCheckMessage();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pwdCheckMessage();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pwdCheckMessage();
            }

            private void pwdCheckMessage() {
                String pwd1 = profile_Pwd.getText();
                String pwd2 = profile_PwdCheck.getText();
                if (pwd1.equals(pwd2)) {
                    profile_PwdMessage.setText("비밀번호 일치");
                } else {
                    profile_PwdMessage.setText("비밀번호 불일치");
                }
            }
        });

        profile_PhoneLabel.setBounds(66, 265, 250, 25);
        profile_Phone.setBounds(171, 263, 150, 25);

        profile_EmailLabel.setBounds(66, 305, 250, 25);
        profile_Email.setBounds(171, 303, 150, 25);

        profile_ModifyButton.setBounds(315, 345, 60, 30);
        profile_ModifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == profile_ModifyButton) {
                    JFrame profile_ModifyPopup = new JFrame();
                    profile_ModifyPopup.setSize(300, 250);
                    profile_ModifyPopup.setVisible(true);
                    profile_ModifyPopup.setLocationRelativeTo(null);
                    profile_ModifyPopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // x 클릭 시 창닫기
                    JPanel profile_ModifyPanel = new JPanel();
                    profile_ModifyPopup.add(profile_ModifyPanel);
                    profile_ModifyPanel.setBackground(Color.white);
                    profile_ModifyPanel.setLayout(null);

                    JLabel profile_ModifyText = new JLabel("입력한 정보로 변경하시겠습니까?");
                    profile_ModifyText.setBounds(50, 60, 200, 20);
                    profile_ModifyPanel.add(profile_ModifyText);

                    JButton profile_ModifyButton_Yes = new JButton("변경");
                    profile_ModifyButton_Yes.setBounds(65, 110, 70, 30);
                    profile_ModifyPanel.add(profile_ModifyButton_Yes);
                    profile_ModifyButton_Yes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            /*
                            String dbUpdate = "UPDATE 테이블명 SET 필드명 = ?, ~";
                            PreparedStatement ps = db_Connection.preparedStatement(dbUpdate);
                            String Pwd_Value = profile_Pwd.getText(); // 텍스트 필드에 입력한 값 불러오기
                            String Phone_Value = profile_Phone.getText();
                            String Mail_Value = profile_Mail.getText();
                            preparedStatement.setString(1, Pwd_Value);
                            preparedStatement.setString(2, Phone_Value);
                            preparedStatement.setString(3, Mail_Value);

                            db_refer = ps.executeUpdate();
                            ps.close();
                            db_Connection.close();

                            if (db_refer > 0) {
                            팝업 "정보가 변경되었습니다."
                            profile_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            } else {
                            팝업 "변경되지 않았습니다. 관리자에게 문의하세요."
                            profile_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            */
                        }
                    });
                    JButton profile_ModifyButton_No = new JButton("아니요");
//        Font no_Font = profile_ModifyButton_No.getFont();
//        profile_ModifyButton_No.setFont(new Font(no_Font.getName(), no_Font.getStyle(), 9));
                    profile_ModifyButton_No.setBounds(145, 110, 75, 30);
                    profile_ModifyPanel.add(profile_ModifyButton_No);
                    profile_ModifyButton_No.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == profile_ModifyButton_No) {
                                profile_ModifyPopup.dispose();
                            }
                        }
                    });
                }
            }
        });

        profile_Frame.setVisible(true);
        profile_Panel.add(profile_MainText);
        profile_Panel.add(profile_NameLabel);
        profile_Panel.add(profile_Name);
        profile_Panel.add(profile_NumberLabel);
        profile_Panel.add(profile_Number);
        profile_Panel.add(profile_PwdLabel);
        profile_Panel.add(profile_Pwd);
        profile_Panel.add(profile_PwdCheckLabel);
        profile_Panel.add(profile_PwdCheck);
        profile_Panel.add(profile_PwdMessage);
        profile_Panel.add(profile_PhoneLabel);
        profile_Panel.add(profile_Phone);
        profile_Panel.add(profile_EmailLabel);
        profile_Panel.add(profile_Email);
        profile_Panel.add(profile_ModifyButton);
    }
    public static void main(String[] args) {
        new Information();
    }
}