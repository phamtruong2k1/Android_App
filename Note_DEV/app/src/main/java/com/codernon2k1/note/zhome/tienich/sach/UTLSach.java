package com.codernon2k1.note.zhome.tienich.sach;

public class UTLSach {
    private Integer id;
    private Integer sachId;
    private String name;
    private String theloai;
    private String tagia;
    private String noidung;

    public UTLSach() {
    }

    public UTLSach(Integer id, Integer sachId, String name, String theloai, String tagia, String noidung) {
        this.id = id;
        this.sachId = sachId;
        this.name = name;
        this.theloai = theloai;
        this.tagia = tagia;
        this.noidung = noidung;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSachId() {
        return sachId;
    }

    public void setSachId(Integer sachId) {
        this.sachId = sachId;
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
