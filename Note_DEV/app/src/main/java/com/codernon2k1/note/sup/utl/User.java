package com.codernon2k1.note.sup.utl;

public class User {
    private Integer id;
    private String account;
    private String password;
    private String name_in_app;
    private String avt;
    private String gmail;
    private String isAct;
    private String friend;
    private String add_friend;
    private String sex;
    private String quenquan;
    private String honnhan;
    private String sdt;
    private String status;

    public User(Integer id, String account, String password, String name_in_app, String avt, String gmail, String isAct, String friend, String add_friend, String sex, String quenquan, String honnhan, String sdt, String status) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name_in_app = name_in_app;
        this.avt = avt;
        this.gmail = gmail;
        this.isAct = isAct;
        this.friend = friend;
        this.add_friend = add_friend;
        this.sex = sex;
        this.quenquan = quenquan;
        this.honnhan = honnhan;
        this.sdt = sdt;
        this.status = status;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName_in_app() {
        return name_in_app;
    }

    public void setName_in_app(String name_in_app) {
        this.name_in_app = name_in_app;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String isAct() {
        return isAct;
    }

    public void setAct(String act) {
        isAct = act;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getAdd_friend() {
        return add_friend;
    }

    public void setAdd_friend(String add_friend) {
        this.add_friend = add_friend;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getQuenquan() {
        return quenquan;
    }

    public void setQuenquan(String quenquan) {
        this.quenquan = quenquan;
    }

    public String getHonnhan() {
        return honnhan;
    }

    public void setHonnhan(String honnhan) {
        this.honnhan = honnhan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
