package com.chat.main;

public class Main extends javax.swing.JFrame {
    public Main() {
        initComponents();
        init();
    }

    private void init() {
        loginFrame.setVisible(true);
        loginFrame.add(loginBtn);
    }

    private void initComponents() {

        loginFrame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        idTextField = new javax.swing.JTextField();
        pwdTextField = new javax.swing.JTextField();
        mainPage1 = new com.chat.form.mainPage();

        loginFrame.setBackground(java.awt.Color.black);
        loginFrame.setMaximumSize(new java.awt.Dimension(400, 300));
        loginFrame.setMinimumSize(new java.awt.Dimension(400, 300));
        loginFrame.setLocationRelativeTo(null);
        loginFrame.requestFocus();

        loginBtn.setText("login");
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });

        idTextField.setText("id");
        idTextField.setMaximumSize(new java.awt.Dimension(251, 38));
        idTextField.setMinimumSize(new java.awt.Dimension(251, 38));
        pwdTextField.setText("pwd");
        pwdTextField.setSize(251, 38);

        javax.swing.GroupLayout loginFrameLayout = new javax.swing.GroupLayout(loginFrame.getContentPane());
        loginFrame.getContentPane().setLayout(loginFrameLayout);
        loginFrameLayout.setHorizontalGroup(
                loginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginFrameLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(loginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(loginFrameLayout.createSequentialGroup()
                                                .addGroup(loginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pwdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(loginBtn)
                                                .addGap(0, 16, Short.MAX_VALUE)))
                                .addGap(86, 86, 86))
        );
        loginFrameLayout.setVerticalGroup(
                loginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginFrameLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(loginFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(loginFrameLayout.createSequentialGroup()
                                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(pwdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(115, Short.MAX_VALUE))
        );

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

}
