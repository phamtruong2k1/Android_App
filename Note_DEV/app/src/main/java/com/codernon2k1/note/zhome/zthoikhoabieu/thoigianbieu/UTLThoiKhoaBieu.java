package com.codernon2k1.note.zhome.zthoikhoabieu.thoigianbieu;

public class UTLThoiKhoaBieu {
    private  int Id ;
    private  int thu ;
    private  String name ;
    private  int gio ;
    private  int phut ;
    private  String Ndghichu;

    public UTLThoiKhoaBieu() {
    }

    public UTLThoiKhoaBieu(int id, int thu, String name, int gio, int phut, String ndghichu) {
        Id = id;
        this.thu = thu;
        this.name = name;
        this.gio = gio;
        this.phut = phut;
        Ndghichu = ndghichu;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNdghichu() {
        return Ndghichu;
    }

    public void setNdghichu(String ndghichu) {
        Ndghichu = ndghichu;
    }
}
