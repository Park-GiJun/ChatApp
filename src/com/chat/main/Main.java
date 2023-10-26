package com.chat.main;

public class Main extends javax.swing.JFrame {
    public Main() {
        initComponents();
        init();
    }

    private void init() {
        loginFrame.setVisible(true);
        loginFrame.add(idTextField);
        loginFrame.add(pwdTextField);
        loginFrame.add(loginBtn);
        loginFrame.add(fixInfoLabel);
    }

    private void initComponents() {

        loginFrame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        idTextField = new javax.swing.JTextField();
        pwdTextField = new javax.swing.JTextField();
        mainPage1 = new com.chat.form.mainPage();
        fixInfoLabel = new javax.swing.JLabel();
        loginMainPanel = new javax.swing.JPanel();

        loginFrame.setBackground(java.awt.Color.black);
        loginFrame.setMaximumSize(new java.awt.Dimension(800, 560));
        loginFrame.setMinimumSize(new java.awt.Dimension(800, 560));
        loginFrame.setLocationRelativeTo(null);
        loginFrame.requestFocus();
        
        // 로그인 프레임 레이아웃
        loginFrame.setLayout(null);
    
        //아이디 패스워드 위치
        idTextField.setBounds(218, 326, 251, 38);
        pwdTextField.setBounds(218,374,251,38);
        loginBtn.setBounds(496, 326, 86, 86);
        fixInfoLabel.setBounds(218,412,124,14);
        loginMainPanel.setBounds(218, 148, 364, 148);
        
        //로그인 패널
		
        
        
        loginBtn.setText("login");
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });

        idTextField.setText("id");
        pwdTextField.setText("pwd");
        fixInfoLabel.setText("정보수정");

        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(mainPage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 560, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(mainPage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {
        loginFrame.dispose();
        mainPage1.setVisible(true);//
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);

            }
        });
    }


    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField idTextField;
    private javax.swing.JTextField pwdTextField;
    private javax.swing.JButton loginBtn;
    private javax.swing.JFrame loginFrame;
    private com.chat.form.mainPage mainPage1;
    private javax.swing.JLabel fixInfoLabel;
    private javax.swing.JPanel loginMainPanel;

}
