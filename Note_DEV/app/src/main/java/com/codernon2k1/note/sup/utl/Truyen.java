package com.codernon2k1.note.sup.utl;

public class Truyen {
    private Integer truyenId;
    private String name;
    private String theloai;
    private String tagia;
    private String noidung;

    public Truyen() {
    }

    public Truyen(Integer truyenId, String name, String theloai, String tagia, String noidung) {
        this.truyenId = truyenId;
        this.name = name;
        this.theloai = theloai;
        this.tagia = tagia;
        this.noidung = noidung;
    }

    public Integer getTruyenId() {
        return truyenId;
    }

    public void setTruyenId(Integer truyenId) {
        this.truyenId = truyenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getTagia() {
        return tagia;
    }

    public void setTagia(String tagia) {
        this.tagia = tagia;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

}
