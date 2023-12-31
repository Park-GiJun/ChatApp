package com.chat;

//중간 다리 역할 클래스
public class Adapter {
   private String user_id;
   private String user_pwd;
   private String name;
   private String num;
   private String email;
   private String cn;
   private String phone;
   private String DBcn;
   private String DBname;
   private boolean pass;
   private ClientConnection client;
   private String[] arr;

   public Adapter() {

   }

   public Adapter(ClientConnection clientconnection) {
      this.client = clientconnection;
   }

   public Adapter(String name, String num) {
      this.name = name;
      this.cn = num;
      System.out.println(name + "---" + cn);
   }

   public void pwdUP(String id, String name) {
      client.pwdUp(id, name);
      System.out.println("adapter pwdup 실행");
      setDBcn(id);
      setDBname(name);
   }

   public void setnewUser(String name, String cn, String dept, String imagefile) {
      client.newUser(name, cn, dept, imagefile);
      System.out.println("adapter setnewUser 실행");
   }

   public void setInfo(String pwd, String phone, String email) {
      client.setProfile(pwd, phone, email);
      System.out.println("adapter setInfo 실행");
      System.out.println(client.setPwd + " " + client.setPhone + " " + client.setEmail);
      setPwd(client.setPwd);
      setPhone(client.setPhone);
      setEmail(client.setEmail);
   }

   public String[] getDeptList() {
      String DeptList[] = client.SignUpDept();
      return DeptList;
   }

   public void setNameTree(String[] ar) {
      this.arr = ar;
   }

   public void setDBcn(String cn) {
      this.DBcn = cn;
   }

   public void setDBname(String name) {
      this.DBname = name;
   }

   public void setPass(boolean pass) {
      this.pass = pass;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setCn(String cn) {
      this.cn = cn;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setNum(String num) {
      this.num = num;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public void setId(String id) {
      this.user_id = id;
   }

   public void setPwd(String pwd) {
      this.user_pwd = pwd;
   }

   public String[] getArr() {
      return arr;
   }

   public String getDBcn() {
      return DBcn;
   }

   public String getDBname() {
      return DBname;
   }

   public boolean getPass() {
      return pass;
   }

   public String getName() {
      return name;
   }

   public String getCn() {
      return cn;
   }

   public String getEmail() {
      return email;
   }

   public String getNum() {
      return num;
   }

   public String getPhone() {
      return phone;
   }

   public String getId() {
      return user_id;
   }

   public String getPwd() {
      return user_pwd;
   }
}