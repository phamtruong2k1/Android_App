package com.codernon2k1.note.sup.utl;

public class Monan {
    private Integer monanId;
    private String username;
    private String avt;
    private String nguyenlieu;
    private String congthuc;
    private String tien;

    public Monan() {}


    public Monan(Integer monanId, String username, String avt, String nguyenlieu, String congthuc, String tien) {
        this.monanId = monanId;
        this.username = username;
        this.avt = avt;
        this.nguyenlieu = nguyenlieu;
        this.congthuc = congthuc;
        this.tien = tien;
    }

    public Integer getMonanId() {
        return monanId;
    }
    public void setMonanId(Integer monanId) {
        this.monanId = monanId;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getNguyenlieu() {
        return nguyenlieu;
    }

    public void setNguyenlieu(String nguyenlieu) {
        this.nguyenlieu = nguyenlieu;
    }

    public String getCongthuc() {
        return congthuc;
    }

    public void setCongthuc(String congthuc) {
        this.congthuc = congthuc;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }
}
