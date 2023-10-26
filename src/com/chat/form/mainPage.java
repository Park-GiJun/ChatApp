package com.chat.form;

public class mainPage extends javax.swing.JPanel {
	public mainPage() {
		initComponents();
		searchPage.setVisible(false);
		messagePage.setVisible(false);
	}

	public void init() {
	}

	private void initComponents() {
		// 패널 추가
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

		// 기본 프레임 사이즈
		setMaximumSize(new java.awt.Dimension(800, 560));
		setMinimumSize(new java.awt.Dimension(800, 560));
		setPreferredSize(new java.awt.Dimension(800, 560));

		// 왼쪽 패널 색상, 사이즈
		leftPanel.setBackground(java.awt.Color.red);
		leftPanel.setMaximumSize(new java.awt.Dimension(100, 560));
		leftPanel.setMinimumSize(new java.awt.Dimension(100, 560));
		leftPanel.setOpaque(false);
		leftPanel.setPreferredSize(new java.awt.Dimension(100, 560));

		// 메인탭 버튼

		mainBtn.setMaximumSize(new java.awt.Dimension(100, 100));
		mainBtn.setMinimumSize(new java.awt.Dimension(100, 100));
		mainBtn.setPreferredSize(new java.awt.Dimension(100, 100));
		mainBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mainBtnMouseClicked(evt);
			}
		});

		// 서치탭 버튼
		searchBtn.setMaximumSize(new java.awt.Dimension(100, 100));
		searchBtn.setPreferredSize(new java.awt.Dimension(100, 100));
		searchBtn.setPreferredSize(new java.awt.Dimension(100, 100));
		searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				searchBtnMouseClicked(evt);
			}
		});

		// 메세지 탭 버튼
		messageBtn.setMaximumSize(new java.awt.Dimension(100, 100));
		messageBtn.setPreferredSize(new java.awt.Dimension(100, 100));
		messageBtn.setPreferredSize(new java.awt.Dimension(100, 100));
		messageBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				messageBtnMouseClicked(evt);
			}
		});

		// 왼쪽 패널 레이아웃
		leftPanel.setBounds(0, 0, 100, 560);
		leftPanel.add(mainBtn);
		leftPanel.add(searchBtn);
		leftPanel.add(messageBtn);
		mainBtn.setText("MainBtn");
		mainBtn.setBounds(0, 0, 100, 100);
		searchBtn.setText("SearchBtn");
		searchBtn.setBounds(0, 100, 100, 100);
		messageBtn.setText("MessageBtn");
		messageBtn.setBounds(0, 200, 100, 100);

		// 메인 페이지 사이즈, 색상
		mainPage.setBackground(java.awt.Color.black);
		mainPage.setMaximumSize(new java.awt.Dimension(700, 560));
		mainPage.setMinimumSize(new java.awt.Dimension(700, 560));
		mainPage.setPreferredSize(new java.awt.Dimension(700, 560));

		// 프로필 사진(패널) 사이즈, 색상
		profilePhoto.setMaximumSize(new java.awt.Dimension(165, 210));
		profilePhoto.setMinimumSize(new java.awt.Dimension(165, 210));
		profilePhoto.setPreferredSize(new java.awt.Dimension(165, 210));

		// 프로필 사진 위치
		javax.swing.GroupLayout profilePhotoLayout = new javax.swing.GroupLayout(profilePhoto);
		profilePhoto.setLayout(profilePhotoLayout);
		profilePhotoLayout.setHorizontalGroup(profilePhotoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 165, Short.MAX_VALUE));
		profilePhotoLayout.setVerticalGroup(profilePhotoLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 210, Short.MAX_VALUE));

		// 프로필 직원 이름
		empName.setForeground(java.awt.Color.white);
		empName.setText("empName");

		// 프로필 직원 사번
		empNum.setForeground(new java.awt.Color(255, 255, 255));
		empNum.setText("empNum");

		// 어쩌구 저쩌구
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("jLabel3");

		// 투두 리스트 패널
		todoList.setMaximumSize(new java.awt.Dimension(310, 170));
		todoList.setMinimumSize(new java.awt.Dimension(310, 170));
		todoList.setPreferredSize(new java.awt.Dimension(310, 170));

		jCheckBox1.setText("jCheckBox1");

		jCheckBox2.setText("jCheckBox2");

		jCheckBox3.setText("jCheckBox3");

		jCheckBox4.setText("jCheckBox4");

		jCheckBox5.setText("jCheckBox5");

		// 투두 리스트 위치
		javax.swing.GroupLayout todoListLayout = new javax.swing.GroupLayout(todoList);
		todoList.setLayout(todoListLayout);
		todoListLayout.setHorizontalGroup(todoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(todoListLayout.createSequentialGroup().addGap(18, 18, 18)
						.addGroup(todoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jCheckBox5).addComponent(jCheckBox4).addComponent(jCheckBox3)
								.addComponent(jCheckBox2).addComponent(jCheckBox1))
						.addContainerGap(206, Short.MAX_VALUE)));
		todoListLayout
				.setVerticalGroup(
						todoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(todoListLayout.createSequentialGroup().addContainerGap()
										.addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(35, 35, 35)));

		// 메인 페이지 요소들 위치
		javax.swing.GroupLayout mainPageLayout = new javax.swing.GroupLayout(mainPage);
		mainPage.setLayout(mainPageLayout);
		mainPageLayout.setHorizontalGroup(mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPageLayout.createSequentialGroup().addGroup(mainPageLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(mainPageLayout.createSequentialGroup().addGap(268, 268, 268).addComponent(
								profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(mainPageLayout.createSequentialGroup().addGap(329, 329, 329)
								.addGroup(mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(empNum).addComponent(empName).addComponent(jLabel3)))
						.addGroup(mainPageLayout.createSequentialGroup().addGap(195, 195, 195).addComponent(todoList,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(195, Short.MAX_VALUE)));
		mainPageLayout.setVerticalGroup(mainPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPageLayout.createSequentialGroup().addGap(25, 25, 25)
						.addComponent(profilePhoto, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(25, 25, 25).addComponent(empName).addGap(25, 25, 25).addComponent(empNum)
						.addGap(25, 25, 25).addComponent(jLabel3)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(todoList, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(23, 23, 23)));

		// 서치 페이지 패널
		searchPage.setBackground(java.awt.Color.cyan);
		searchPage.setMaximumSize(new java.awt.Dimension(700, 560));
		searchPage.setMinimumSize(new java.awt.Dimension(700, 560));
		searchPage.setPreferredSize(new java.awt.Dimension(700, 560));

		// 서치 패널
		searchPanel.setBackground(java.awt.Color.white);
		searchPanel.setMaximumSize(new java.awt.Dimension(230, 560));
		searchPanel.setMinimumSize(new java.awt.Dimension(230, 560));
		searchPanel.setPreferredSize(new java.awt.Dimension(230, 560));

		// search가 들어가는 텍스트 필드
		searchField.setText("jTextField1");
		searchField.setMaximumSize(new java.awt.Dimension(193, 44));
		searchField.setMinimumSize(new java.awt.Dimension(193, 44));
		searchField.setPreferredSize(new java.awt.Dimension(193, 44));

		// 서치 트리
		jScrollPane1.setViewportView(jTree1);

		javax.swing.GroupLayout searchTreeLayout = new javax.swing.GroupLayout(searchTree);
		searchTree.setLayout(searchTreeLayout);
		searchTreeLayout.setHorizontalGroup(searchTreeLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1));
		searchTreeLayout
				.setVerticalGroup(searchTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));

		// 서치 페이지 패널의 위치 지정
		javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
		searchPanel.setLayout(searchPanelLayout);
		searchPanelLayout
				.setHorizontalGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								searchPanelLayout.createSequentialGroup().addGap(20, 20, 20)
										.addGroup(searchPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(searchTree, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(17, 17, 17)));
		searchPanelLayout
				.setVerticalGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(searchPanelLayout.createSequentialGroup().addGap(28, 28, 28)
								.addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)
								.addComponent(searchTree, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20)));

		javax.swing.GroupLayout searchPageLayout = new javax.swing.GroupLayout(searchPage);
		searchPage.setLayout(searchPageLayout);
		searchPageLayout
				.setHorizontalGroup(searchPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(searchPageLayout.createSequentialGroup()
								.addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)));
		searchPageLayout
				.setVerticalGroup(searchPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(searchPageLayout.createSequentialGroup()
								.addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)));

		// 메세지 페이지 패널
		messagePage.setBackground(java.awt.Color.pink);
		messagePage.setMaximumSize(new java.awt.Dimension(700, 560));
		messagePage.setMinimumSize(new java.awt.Dimension(700, 560));

		// 메세지 좌측 초록색 리스트
		messageList.setBackground(java.awt.Color.green);
		messageList.setMaximumSize(new java.awt.Dimension(90, 560));
		messageList.setMinimumSize(new java.awt.Dimension(90, 560));
		messageList.setPreferredSize(new java.awt.Dimension(90, 560));

		// 쪽지함 패널
		postPanel.setMaximumSize(new java.awt.Dimension(90, 70));
		postPanel.setMinimumSize(new java.awt.Dimension(90, 70));
		postPanel.setPreferredSize(new java.awt.Dimension(90, 70));

		// 쪽지함 진입용 버튼
		postBtn.setText("postBtn");
		postBtn.setMaximumSize(new java.awt.Dimension(90, 70));
		postBtn.setMinimumSize(new java.awt.Dimension(90, 70));
		postBtn.setPreferredSize(new java.awt.Dimension(90, 70));

		javax.swing.GroupLayout postPanelLayout = new javax.swing.GroupLayout(postPanel);
		postPanel.setLayout(postPanelLayout);
		postPanelLayout
				.setHorizontalGroup(postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(postPanelLayout.createSequentialGroup()
								.addComponent(postBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		postPanelLayout.setVerticalGroup(postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(postPanelLayout.createSequentialGroup()
						.addComponent(postBtn, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout messageListLayout = new javax.swing.GroupLayout(messageList);
		messageList.setLayout(messageListLayout);
		messageListLayout.setHorizontalGroup(messageListLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(messageListLayout.createSequentialGroup().addComponent(postPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(0, 0, 0)));
		messageListLayout
				.setVerticalGroup(messageListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(messageListLayout.createSequentialGroup()
								.addComponent(postPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 490, Short.MAX_VALUE)));

		// 채팅방 화면
		chatBox.setBackground(java.awt.Color.pink);
		chatBox.setMaximumSize(new java.awt.Dimension(610, 530));
		chatBox.setMinimumSize(new java.awt.Dimension(610, 530));
		chatBox.setPreferredSize(new java.awt.Dimension(610, 530));

		javax.swing.GroupLayout chatBoxLayout = new javax.swing.GroupLayout(chatBox);
		chatBox.setLayout(chatBoxLayout);
		chatBoxLayout.setHorizontalGroup(chatBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 610, Short.MAX_VALUE));
		chatBoxLayout.setVerticalGroup(chatBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 530, Short.MAX_VALUE));
		// 메세지 입력
		enterMessage.setText("enterMessage");

		javax.swing.GroupLayout messagePageLayout = new javax.swing.GroupLayout(messagePage);
		messagePage.setLayout(messagePageLayout);
		messagePageLayout.setHorizontalGroup(messagePageLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(messagePageLayout.createSequentialGroup()
						.addComponent(messageList, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(messagePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(chatBox, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(enterMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 610,
										Short.MAX_VALUE))));
		messagePageLayout.setVerticalGroup(messagePageLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(messagePageLayout.createSequentialGroup().addGroup(messagePageLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, messagePageLayout.createSequentialGroup()
								.addComponent(chatBox, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0).addComponent(enterMessage))
						.addComponent(messageList, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 0, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(700, 700, 700))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(100, 100, 100)
								.addComponent(searchPage, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 100, Short.MAX_VALUE).addComponent(messagePage,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(100, 100, 100)
								.addComponent(mainPage, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(searchPage,
						javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
						messagePage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 0, 0)
										.addComponent(mainPage, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(0, 0, 0))));
	}

	// 서치버튼 클릭
	private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_searchBtnMouseClicked
		mainPage.setVisible(false);
		searchPage.setVisible(true);
		messagePage.setVisible(false);
	}

	// 메인 버튼 클릭
	private void mainBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_mainBtnMouseClicked
		mainPage.setVisible(true);
		searchPage.setVisible(false);
		messagePage.setVisible(false);
	}

	// 메세지 버튼 클릭
	private void messageBtnMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_messageBtnMouseClicked
		mainPage.setVisible(false);
		searchPage.setVisible(false);
		messagePage.setVisible(true);
	}

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
}
