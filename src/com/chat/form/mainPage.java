package com.chat.form;

public class mainPage extends javax.swing.JPanel {
    public mainPage() {
        initComponents();
        searchPage.setVisible(false);
        messagePage.setVisible(false);
    }
  
    public void init(){  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        mainBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        messageBtn = new javax.swing.JButton();
        mainPage = new javax.swing.JPanel();
        profilePhoto = new javax.swing.JPanel();
        empName = new javax.swing.JLabel();
        empNum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        todoList = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        searchPage = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchTree = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        messagePage = new javax.swing.JPanel();
        messageList = new javax.swing.JPanel();
        postPanel = new javax.swing.JPanel();
        postBtn = new javax.swing.JButton();
        chatBox = new javax.swing.JPanel();
        enterMessage = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(800, 560));
        setMinimumSize(new java.awt.Dimension(800, 560));
        setPreferredSize(new java.awt.Dimension(800, 560));

        leftPanel.setBackground(java.awt.Color.red);
        leftPanel.setMaximumSize(new java.awt.Dimension(100, 560));
        leftPanel.setMinimumSize(new java.awt.Dimension(100, 560));
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new java.awt.Dimension(100, 560));

        mainBtn.setText("MainBtn");
        mainBtn.setMaximumSize(new java.awt.Dimension(100, 100));
        mainBtn.setMinimumSize(new java.awt.Dimension(100, 100));
        mainBtn.setPreferredSize(new java.awt.Dimension(100, 100));
        mainBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainBtnMouseClicked(evt);
            }
        });

        searchBtn.setText("SearchBtn");
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });

        messageBtn.setText("MessageBtn");
        messageBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(messageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(mainBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPage.setBackground(java.awt.Color.black);
        mainPage.setMaximumSize(new java.awt.Dimension(700, 560));
        mainPage.setMinimumSize(new java.awt.Dimension(700, 560));
        mainPage.setPreferredSize(new java.awt.Dimension(700, 560));

        profilePhoto.setMaximumSize(new java.awt.Dimension(165, 210));
        profilePhoto.setMinimumSize(new java.awt.Dimension(165, 210));
        profilePhoto.setPreferredSize(new java.awt.Dimension(165, 210));

        javax.swing.GroupLayout profilePhotoLayout = new javax.swing.GroupLayout(profilePhoto);
        profilePhoto.setLayout(profilePhotoLayout);
        profilePhotoLayout.setHorizontalGroup(
            profilePhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );
        profilePhotoLayout.setVerticalGroup(
            profilePhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        empName.setForeground(java.awt.Color.white);
        empName.setText("empName");

        empNum.setForeground(new java.awt.Color(255, 255, 255));
        empNum.setText("empNum");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("jLabel3");

        todoList.setMaximumSize(new java.awt.Dimension(310, 170));
        todoList.setMinimumSize(new java.awt.Dimension(310, 170));
        todoList.setPreferredSize(new java.awt.Dimension(310, 170));

        jCheckBox1.setText("jCheckBox1");

        jCheckBox2.setText("jCheckBox2");

        jCheckBox3.setText("jCheckBox3");

        jCheckBox4.setText("jCheckBox4");

        jCheckBox5.setText("jCheckBox5");

        javax.swing.GroupLayout todoListLayout = new javax.swing.GroupLayout(todoList);
        todoList.setLayout(todoListLayout);
        todoListLayout.setHorizontalGroup(
            todoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todoListLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(todoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        todoListLayout.setVerticalGroup(
            todoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todoListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout mainPageLayout = new javax.swing.GroupLayout(mainPage);
        mainPage.setLayout(mainPageLayout);
        mainPageLayout.setHorizontalGroup(
            mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPageLayout.createSequentialGroup()
                .addGroup(mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPageLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPageLayout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addGroup(mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(empNum)
                            .addComponent(empName)
                            .addComponent(jLabel3)))
                    .addGroup(mainPageLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(todoList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        mainPageLayout.setVerticalGroup(
            mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPageLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(empName)
                .addGap(25, 25, 25)
                .addComponent(empNum)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todoList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        searchPage.setBackground(java.awt.Color.cyan);
        searchPage.setMaximumSize(new java.awt.Dimension(700, 560));
        searchPage.setMinimumSize(new java.awt.Dimension(700, 560));
        searchPage.setPreferredSize(new java.awt.Dimension(700, 560));

        searchPanel.setBackground(java.awt.Color.white);
        searchPanel.setMaximumSize(new java.awt.Dimension(230, 560));
        searchPanel.setMinimumSize(new java.awt.Dimension(230, 560));
        searchPanel.setPreferredSize(new java.awt.Dimension(230, 560));

        searchField.setText("jTextField1");
        searchField.setMaximumSize(new java.awt.Dimension(193, 44));
        searchField.setMinimumSize(new java.awt.Dimension(193, 44));
        searchField.setPreferredSize(new java.awt.Dimension(193, 44));

        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout searchTreeLayout = new javax.swing.GroupLayout(searchTree);
        searchTree.setLayout(searchTreeLayout);
        searchTreeLayout.setHorizontalGroup(
            searchTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        searchTreeLayout.setVerticalGroup(
            searchTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(searchTree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout searchPageLayout = new javax.swing.GroupLayout(searchPage);
        searchPage.setLayout(searchPageLayout);
        searchPageLayout.setHorizontalGroup(
            searchPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPageLayout.createSequentialGroup()
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        searchPageLayout.setVerticalGroup(
            searchPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPageLayout.createSequentialGroup()
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        messagePage.setBackground(java.awt.Color.pink);
        messagePage.setMaximumSize(new java.awt.Dimension(700, 560));
        messagePage.setMinimumSize(new java.awt.Dimension(700, 560));

        messageList.setBackground(java.awt.Color.green);
        messageList.setMaximumSize(new java.awt.Dimension(90, 560));
        messageList.setMinimumSize(new java.awt.Dimension(90, 560));
        messageList.setPreferredSize(new java.awt.Dimension(90, 560));

        postPanel.setMaximumSize(new java.awt.Dimension(90, 70));
        postPanel.setMinimumSize(new java.awt.Dimension(90, 70));
        postPanel.setPreferredSize(new java.awt.Dimension(90, 70));

        postBtn.setText("postBtn");
        postBtn.setMaximumSize(new java.awt.Dimension(90, 70));
        postBtn.setMinimumSize(new java.awt.Dimension(90, 70));
        postBtn.setPreferredSize(new java.awt.Dimension(90, 70));

        javax.swing.GroupLayout postPanelLayout = new javax.swing.GroupLayout(postPanel);
        postPanel.setLayout(postPanelLayout);
        postPanelLayout.setHorizontalGroup(
            postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postPanelLayout.createSequentialGroup()
                .addComponent(postBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        postPanelLayout.setVerticalGroup(
            postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postPanelLayout.createSequentialGroup()
                .addComponent(postBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout messageListLayout = new javax.swing.GroupLayout(messageList);
        messageList.setLayout(messageListLayout);
        messageListLayout.setHorizontalGroup(
            messageListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageListLayout.createSequentialGroup()
                .addComponent(postPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        messageListLayout.setVerticalGroup(
            messageListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messageListLayout.createSequentialGroup()
                .addComponent(postPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 490, Short.MAX_VALUE))
        );

        chatBox.setBackground(java.awt.Color.pink);
        chatBox.setMaximumSize(new java.awt.Dimension(610, 530));
        chatBox.setMinimumSize(new java.awt.Dimension(610, 530));
        chatBox.setPreferredSize(new java.awt.Dimension(610, 530));

        javax.swing.GroupLayout chatBoxLayout = new javax.swing.GroupLayout(chatBox);
        chatBox.setLayout(chatBoxLayout);
        chatBoxLayout.setHorizontalGroup(
            chatBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        chatBoxLayout.setVerticalGroup(
            chatBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        enterMessage.setText("enterMessage");

        javax.swing.GroupLayout messagePageLayout = new javax.swing.GroupLayout(messagePage);
        messagePage.setLayout(messagePageLayout);
        messagePageLayout.setHorizontalGroup(
            messagePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePageLayout.createSequentialGroup()
                .addComponent(messageList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(messagePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enterMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)))
        );
        messagePageLayout.setVerticalGroup(
            messagePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePageLayout.createSequentialGroup()
                .addGroup(messagePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, messagePageLayout.createSequentialGroup()
                        .addComponent(chatBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(enterMessage))
                    .addComponent(messageList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(700, 700, 700))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(searchPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 100, Short.MAX_VALUE)
                    .addComponent(messagePage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(mainPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(searchPage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(messagePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
       mainPage.setVisible(false);
       searchPage.setVisible(true);
       messagePage.setVisible(false);
    }//GEN-LAST:event_searchBtnMouseClicked

    private void mainBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainBtnMouseClicked
     mainPage.setVisible(true);
     searchPage.setVisible(false);
     messagePage.setVisible(false); 
    }//GEN-LAST:event_mainBtnMouseClicked

    private void messageBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageBtnMouseClicked
        mainPage.setVisible(false);
        searchPage.setVisible(false);
        messagePage.setVisible(true);
    }//GEN-LAST:event_messageBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chatBox;
    private javax.swing.JLabel empName;
    private javax.swing.JLabel empNum;
    private javax.swing.JTextField enterMessage;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton mainBtn;
    private javax.swing.JPanel mainPage;
    private javax.swing.JButton messageBtn;
    private javax.swing.JPanel messageList;
    private javax.swing.JPanel messagePage;
    private javax.swing.JButton postBtn;
    private javax.swing.JPanel postPanel;
    private javax.swing.JPanel profilePhoto;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchPage;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel searchTree;
    private javax.swing.JPanel todoList;
    // End of variables declaration//GEN-END:variables
}
