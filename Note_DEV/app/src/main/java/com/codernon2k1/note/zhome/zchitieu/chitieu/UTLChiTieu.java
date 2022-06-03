package com.codernon2k1.note.zhome.zchitieu.chitieu;

public class UTLChiTieu {

    private  int id;
    private String name;
    private int ngay;
    private int thang;
    private int nam;
    private int gio;
    private int phut;
    private int tien;
    private String title;


    public UTLChiTieu() {
    }

    public UTLChiTieu(int id, String name, int ngay, int thang, int nam, int gio, int phut, int tien, String title) {
        this.id = id;
        this.name = name;
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
        this.gio = gio;
        this.phut = phut;
        this.tien = tien;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getGio() {
        return gio;
    }

    public void setGio(int gio) {
        this.gio = gio;
    }

    public int getPhut() {
        return phut;
    }

    public void setPhut(int phut) {
        this.phut = phut;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
